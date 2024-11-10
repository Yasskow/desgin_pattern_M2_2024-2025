package fr.uge.poo.question2;

import java.util.Objects;

public interface ImageGenerator {
    String name();
    int size();
    double hue();

    static ImageGenerator download(String url) {
        var parts = url.split("/");
        var name = parts[parts.length - 1];
        var size = Math.abs(name.hashCode()) % 1_000_000;
        var hue = Math.abs(name.hashCode() % 255) / 255.0;
        System.out.println("Downloading image from " + url + " will take " + size % 10 + " seconds");
        try {
            Thread.sleep((size % 10) * 1000);
        } catch (InterruptedException e) {
            // not a good idea but it makes things easier
            throw new RuntimeException(e);
        }
        return new Image(name, size, hue);
    }

    static ImageGenerator downloadLazy(String url){
        return new ImageLazy(url);
    }

    class ImageLazy implements ImageGenerator {
        private ImageGenerator image;
        private final String url;

        public ImageLazy(String url) {
            this.url = Objects.requireNonNull(url);
        }

        public void initiate(){
            if(image != null){
                return;
            }

            this.image = ImageGenerator.download(url);
        }

        @Override
        public String name() {
            initiate();
            return image.name();
        }

        @Override
        public int size() {
            initiate();
            return image.size();
        }

        @Override
        public double hue() {
            initiate();
            return image.hue();
        }
    }

    class Image implements ImageGenerator{
        private final String name;
        private final int size;
        private final double hue;

        private Image(String name, int size, double hue) {
            Objects.requireNonNull(name);
            if (size <= 0) {
                throw new IllegalStateException();
            }
            this.name = name;
            this.size = size;
            this.hue = hue;
        }

        public String name() {
            return name;
        }

        public int size() {
            return size;
        }

        public double hue() {
            return hue;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Image)) return false;

            Image image = (Image) o;

            if (size != image.size) return false;
            if (Double.compare(image.hue, hue) != 0) return false;
            return name.equals(image.name);
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = name.hashCode();
            result = 31 * result + size;
            temp = Double.doubleToLongBits(hue);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
}
