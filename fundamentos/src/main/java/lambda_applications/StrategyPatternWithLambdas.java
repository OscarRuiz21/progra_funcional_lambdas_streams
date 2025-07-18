package lambda_applications;

import java.util.List;

public class StrategyPatternWithLambdas {
    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Bear");
        product1.setUserType("BASIC");
        product1.setPrice(150.0);


        Product product2 = new Product();
        product2.setId(1L);
        product2.setName("Bear");
        product2.setUserType("PLUS");
        product2.setPrice(150.0);

        Product product3 = new Product();
        product3.setId(1L);
        product3.setName("Bear");
        product3.setUserType("PRIME");
        product3.setPrice(150.0);

        List<Product> products = List.of(product1, product2, product3);

        products.forEach(p -> {
            switch(p.getUserType()){
                case "BASIC": p.setDiscountStrategy(price -> price * 0.0); break;
                case "PLUS": p.setDiscountStrategy(price -> price * 0.1);break;
                case "PRIME": p.setDiscountStrategy(price -> price * 0.5);break;
            }
        });

        products.forEach(
                product -> {
                    var discount = product.getDiscountStrategy().applyDiscount(product.getPrice());
                    System.out.println(product);
                    System.out.println("Discount: " + discount);
                    System.out.println("Total: " + (product.getPrice() - discount));
                    System.out.println("---------------------------------------");
                }
        );



    }
}


@FunctionalInterface
interface ApplyDiscountStrategy{
    Double applyDiscount(Double price);
}

class Product{
    private Long id;
    private String name;
    private String userType;
    private Double price;
    private ApplyDiscountStrategy discountStrategy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    public ApplyDiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(ApplyDiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userType='" + userType + '\'' +
                ", price=" + price +
                ", discountStrategy=" + discountStrategy +
                '}';
    }
}

