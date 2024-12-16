public class Main {
    public static void main(String[] args) {
        // Khởi tạo Marketplace
        Marketplace marketplace = new Marketplace();
        marketplace.showItems();

        // Truy xuất và sử dụng vật phẩm theo tên
        System.out.println(marketplace.useItem("Axe of Power"));
        System.out.println(marketplace.useItem("Health Potion"));
        System.out.println(marketplace.useItem("Helmet of Wisdom"));
        System.out.println(marketplace.useItem("Skyward Atlas"));
    }
}
