package P8;

class FileResource implements AutoCloseable {

    FileResource() {
        System.out.println("Resource opened.");
    }

    public void useResource() {
        System.out.println("Resource is being used.");
    }

    @Override
    public void close() {
        System.out.println("Resource closed.");
    }
}

public class AutoCloseableDemo {
    public static void main(String[] args) {

        try (FileResource resource = new FileResource()) {

            resource.useResource();

            System.out.println("Something went wrong.");

            throw new RuntimeException("Original error occurred.");
        }

        catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}