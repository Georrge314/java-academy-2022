package course.demos.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class NioLocking {
    static final int LENGTH = 0x8FFFFFF; // 120MB
    static FileChannel fc;

    public static void main(String[] args) {
        try {
            fc = new RandomAccessFile("test.db", "rw").getChannel();
            MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
            for (int i = 0; i < LENGTH; i++) {
                out.put((byte)'x');
            }
            new LockUpdate(out, 0, LENGTH / 3);
            new LockUpdate(out, LENGTH / 2, LENGTH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class LockUpdate extends Thread {
        private ByteBuffer buff;
        private int start, end;

        public LockUpdate(ByteBuffer memoryMapBuff, int start, int end) {
            memoryMapBuff.limit(end);
            memoryMapBuff.position(start);
            this.buff = memoryMapBuff.slice();
            this.start = start;
            this.end = end;
            start();
        }

        @Override
        public void run() {
            try {
                FileLock lock = fc.lock(start, end, false);
                System.out.printf("Successfully locked range [%d,%d].%n", start, end);
                //update data
                while (buff.position() < buff.limit() - 1) {
                    var value = (byte) (buff.get() + 1);
                    buff.position(buff.position() - 1);
                    buff.put(value);
                }
                //release file lock
                lock.release();
                System.out.printf("Successfully unlocked range [%d,%d].%n", start, end);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
