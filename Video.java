public class Video {
    String title;
    String category;
    double duration;
    String resolution;
    String uploader;

    Video(String title, String category, double duration, String resolution, String uploader)
    {
        this.title = title;
        this.category = category;
        this.duration = duration;
        this.resolution = resolution;
        this.uploader = uploader;
    }

    public void printInfo()
    {
        System.out.println("\tInformation of Video");
        System.out.println("Title : " + title);
        System.out.println("Category : " + category);
        System.out.println("Duration : " + duration + " minutes");
        System.out.println("Resolution : " + resolution);
        System.out.println("Uploader : " + uploader);
        System.out.println("-".repeat(40));
    }
}