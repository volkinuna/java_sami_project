package customer.project;

public class VIPCustomer extends Customer {

    // 필드
    private int agentID; // 상담원ID
    double saleRatio;    // 할인율

    // 생성자
    public VIPCustomer(int customerID, String customerName, int agentID) {
        super(customerID, customerName);

        super.customerGrade = "VIP";
        super.bonusRatio = 0.05;
        this.saleRatio = 0.1;
        this.agentID = agentID;
    }

    // 메소드
    @Override
    public int calcPrice(int price) {
        bonusPoint += (price * bonusRatio);      // 포인트 적립
        return price - (int)(price * saleRatio); // 지불할 금액(할인된 금액 적용)
    }

    @Override
    public String showCustomerInfo() {
        return super.showCustomerInfo() + ", 담담 상담원 ID : " + agentID;
    }

    // Getter
    public int getAgentID() {
        return agentID;
    }
}
