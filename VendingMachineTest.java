package codetest;

import java.util.Scanner;

// 음료수 자판기를 나타내는 기본 클래스
class VendingMachine {
    private int stock;      // 음료수 재고
    private int revenue;    // 수익금

    // 기본 생성자
    public VendingMachine() {
        stock = 0;
        revenue = 0;
    }

    // 재고를 지정하는 생성자
    public VendingMachine(int stock) {
        this.stock = stock;
        this.revenue = 0;
    }

    // 수익금 반환
    public int getRevenue() {
        return revenue;
    }

    // 재고 반환
    public int getStock() {
        return stock;
    }

    // 재고 추가
    public void addStock(int amount) {
        stock += amount;
    }

    // 음료수 판매
    public void sellDrink(int price) {
        if (stock > 0) {
            stock--;
            revenue += price; // 음료수 판매로 인한 수익 추가
        } else {
            System.out.println("음료수가 모두 소진되었습니다.");
        }
    }
}

// 콜라 자판기 클래스, VendingMachine 클래스를 확장
class ColaVendingMachine extends VendingMachine {
    private int price; // 콜라 가격

    // 생성자
    public ColaVendingMachine(int stock, int price) {
        super(stock);
        this.price = price;
    }

    // 콜라 가격 반환
    public int getPrice() {
        return price;
    }

    // 콜라 음료수 판매
    @Override
    public void sellDrink(int price) {
        if (getStock() > 0) {
            addStock(-1);
            System.out.println("콜라를 판매합니다.");
            super.sellDrink(price);
        } else {
            System.out.println("음료수가 모두 소진되었습니다.");
        }
    }
}

// 주스 자판기 클래스, VendingMachine 클래스를 확장
class JuiceVendingMachine extends VendingMachine {
    private int price;    // 주스 가격
    private String flavor; // 주스 풍미

    // 생성자
    public JuiceVendingMachine(int stock, String flavor, int price) {
        super(stock);
        this.flavor = flavor;
        this.price = price;
    }

    // 주스 풍미 반환
    public String getFlavor() {
        return flavor;
    }

    // 주스 가격 반환
    public int getPrice() {
        return price;
    }

    // 주스 음료수 판매
    @Override
    public void sellDrink(int price) {
        if (getStock() > 0) {
            addStock(-1);
            System.out.println(flavor + " 주스를 판매합니다.");
            super.sellDrink(price);
        } else {
            System.out.println("음료수가 모두 소진되었습니다.");
        }
    }
}

// 재고 추가 관련 유틸리티 클래스
class StockAddition {
    public static void addStock(VendingMachine machine, int amount) {
        machine.addStock(amount);
        System.out.println("음료수 " + amount + "개를 추가했습니다. 현재 재고: " + machine.getStock());
    }
}

// 메인 테스트 클래스
public class VendingMachineTest {
    public static void main(String[] args) {
        // 콜라 자판기 생성
        ColaVendingMachine colaMachine = new ColaVendingMachine(10, 1500);

        // 주스 자판기 생성
        JuiceVendingMachine juiceMachine = new JuiceVendingMachine(5, "포도", 1000);
        System.out.println("콜라 자판기 재고: " + colaMachine.getStock()+"개");
        System.out.println("콜라 자판기 가격: " + colaMachine.getPrice()+"원");
        
        // 주스 종류와 가격 출력
        System.out.println(juiceMachine.getFlavor()+" 주스 자판기 재고: " + juiceMachine.getStock()+"개");
        System.out.println(juiceMachine.getFlavor()+" 주스 자판기 가격: " + juiceMachine.getPrice()+"원");
        
        // 메뉴 출력
        System.out.println("1. 콜라 구매");
        System.out.println("2. 주스 구매");
        System.out.println("3. 재고 확인");
        System.out.println("4. 수익 확인");
        System.out.println("5. 콜라 재고 채우기");
        System.out.println("6. 주스 재고 채우기");
        System.out.println("77. 종료");
        System.out.print("메뉴를 선택하세요: ");
        
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int choice = scanner.nextInt();
            
            switch (choice) {
                // 콜라 구매
                case 1:
                    colaMachine.sellDrink(colaMachine.getPrice());
                    break;
                // 주스 구매
                case 2:
                    juiceMachine.sellDrink(juiceMachine.getPrice());
                    break;
                // 재고 확인
                case 3:
                    System.out.println("콜라 자판기 재고: " + colaMachine.getStock());
                    System.out.println("주스 자판기 재고: " + juiceMachine.getStock());
                    break;
                // 수익 확인
                case 4:
                    System.out.println("콜라 자판기 수익: " + colaMachine.getRevenue() + "원");
                    System.out.println("주스 자판기 수익: " + juiceMachine.getRevenue() + "원");
                    break;
                // 콜라 재고 채우기
                case 5:
                    System.out.print("추가할 콜라 개수: ");
                    int colaAmount = scanner.nextInt();
                    StockAddition.addStock(colaMachine, colaAmount);
                    break;
                // 주스 재고 채우기
                case 6:
                    System.out.print("추가할 주스 개수: ");
                    int juiceAmount = scanner.nextInt();
                    StockAddition.addStock(juiceMachine, juiceAmount);
                    break;
                // 종료
                case 77:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                // 잘못된 입력 처리
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    break;
            }

            System.out.print("메뉴를 선택하세요: ");
        }
    }
}






