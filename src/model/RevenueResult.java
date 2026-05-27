package model;

public class RevenueResult {
    private double totalRevenue;
    private double totalCosts;
    private int numberOfSales;
    private double mostExpensiveSalePrice;
    private double cheapestSalePrice;
    private double mostExpensivePurchasePrice;
    private double cheapestPurchasePrice;

    public RevenueResult(double totalRevenue, double totalCosts, int numberOfSales,
                         double mostExpensiveSalePrice, double cheapestSalePrice,
                         double mostExpensivePurchasePrice, double cheapestPurchasePrice) {
        this.totalRevenue = totalRevenue;
        this.totalCosts = totalCosts;
        this.numberOfSales = numberOfSales;
        this.mostExpensiveSalePrice = mostExpensiveSalePrice;
        this.cheapestSalePrice = cheapestSalePrice;
        this.mostExpensivePurchasePrice = mostExpensivePurchasePrice;
        this.cheapestPurchasePrice = cheapestPurchasePrice;
    }

    public double getTotalRevenue() {return totalRevenue;}
    public double getTotalCosts() {return totalCosts;}
    public int getNumberOfSales() {return numberOfSales;}
    public double getMostExpensiveSalePrice() {return mostExpensiveSalePrice;}
    public double getCheapestSalePrice() {return cheapestSalePrice;}
    public double getMostExpensivePurchasePrice() {return mostExpensivePurchasePrice;}
    public double getCheapestPurchasePrice() {return cheapestPurchasePrice;}

    public double getNetProfit() {
        return totalCosts - totalRevenue;
    }

}
