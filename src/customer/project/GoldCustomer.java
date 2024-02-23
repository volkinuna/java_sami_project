package customer.project;

public class GoldCustomer extends Customer {

    // 필드
    double saleRatio; // 할인율(할인율은 Gold, VIP 등급만 가지고 있음)

    // 생성자
    public GoldCustomer(int customerID, String customerName) {
        super(customerID, customerName);

        super.customerGrade = "GOLD";
        super.bonusRatio = 0.02;
        this.saleRatio = 0.1;
    }
    
    // 메소드
    @Override
    public int calcPrice(int price) {
        bonusPoint += (price * bonusRatio);      // 포인트 적립
        return price - (int)(price * saleRatio); // 지불할 금액(할인된 금액 차감)
    }
}
