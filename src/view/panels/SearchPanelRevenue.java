package view.panels;

import business.RevenueBusiness;
import exception.DataAccessException;
import exception.InvalidInputException;
import model.RevenueResult;
import view.components.DialogMessage;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class SearchPanelRevenue extends JPanel {
    private JSpinner dateStartSpinner;
    private JSpinner dateEndSpinner;
    private JButton calculateButton;

    private JLabel labelTotalRevenue;
    private JLabel labelTotalCosts;
    private JLabel labelNetProfit;
    private JLabel labelNumberOfSales;
    private JLabel labelMaxSale;
    private JLabel labelMinSale;
    private JLabel labelMaxPurchase;
    private JLabel labelMinPurchase;

    public SearchPanelRevenue() {
        SpinnerDateModel startModel = new SpinnerDateModel();
        dateStartSpinner = new JSpinner(startModel);

        dateStartSpinner.setEditor(new JSpinner.DateEditor(dateStartSpinner, "yyyy-MM-dd"));

        SpinnerDateModel endModel = new SpinnerDateModel();
        dateEndSpinner = new JSpinner(endModel);
        dateEndSpinner.setEditor(new JSpinner.DateEditor(dateEndSpinner, "yyyy-MM-dd"));

        dateEndSpinner.setValue(Calendar.getInstance().getTime());

        calculateButton = new JButton("Calculer");

        labelTotalRevenue = new JLabel("-");
        labelTotalCosts = new JLabel("-");
        labelNetProfit = new JLabel("-");
        labelNumberOfSales = new JLabel("-");
        labelMaxSale = new JLabel("-");
        labelMinSale = new JLabel("-");
        labelMaxPurchase = new JLabel("-");
        labelMinPurchase = new JLabel("-");

        calculateButton.addActionListener(e -> calculateRevenue());

        layoutComponents();
    }

    private void addResultRow(JPanel panel, String label, JLabel value) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row.add(new JLabel(label));
        row.add(value);
        panel.add(row);
    }

    private void layoutComponents() {
        setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createTitledBorder("Calcul du chiffre d'affaires"));
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));
        formPanel.add(new JLabel("Date de début :"));
        formPanel.add(dateStartSpinner);
        formPanel.add(new JLabel("Date de fin :"));
        formPanel.add(dateEndSpinner);
        formPanel.add(new JLabel());
        formPanel.add(calculateButton);

        JPanel resultPanel = new JPanel();
        resultPanel.setBorder(BorderFactory.createTitledBorder("Résultats"));
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        addResultRow(resultPanel, "Chiffre d'affaires :", labelTotalRevenue);
        addResultRow(resultPanel, "Total charges :", labelTotalCosts);
        addResultRow(resultPanel, "Bénéfice net :", labelNetProfit);
        addResultRow(resultPanel, "Nombre de ventes :", labelNumberOfSales);
        addResultRow(resultPanel, "Vente la plus chère :", labelMaxSale);
        addResultRow(resultPanel, "Vente la moins chère :", labelMinSale);
        addResultRow(resultPanel, "Achat le plus cher :", labelMaxPurchase);
        addResultRow(resultPanel, "Achat le moins cher :", labelMinPurchase);

        add(formPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
    }

    private void calculateRevenue(){
        try {
            Date startDate = (Date) dateStartSpinner.getValue();
            Date endDate = (Date) dateEndSpinner.getValue();

            LocalDate dateStart = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dateEnd = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            RevenueBusiness business = new RevenueBusiness();
            RevenueResult result = business.calculateRevenue(dateStart, dateEnd);

            labelTotalRevenue.setText(String.format("%.2f €", result.getTotalRevenue()));
            labelTotalCosts.setText(String.format("%.2f €", result.getTotalCosts()));
            labelNetProfit.setText(String.format("%.2f €", result.getNetProfit()));
            labelNumberOfSales.setText(String.valueOf(result.getNumberOfSales()));
            labelMaxSale.setText(String.format("%.2f €", result.getMostExpensiveSalePrice()));
            labelMinSale.setText(String.format("%.2f €", result.getCheapestSalePrice()));
            labelMaxPurchase.setText(String.format("%.2f €", result.getMostExpensivePurchasePrice()));
            labelMinPurchase.setText(String.format("%.2f €", result.getCheapestPurchasePrice()));

        } catch (InvalidInputException e) {
            DialogMessage.errorMessage(this, "Erreur de saisie", e.getMessage());
        } catch (DataAccessException e) {
            DialogMessage.errorMessage(this, "Erreur base de données", e.getMessage());
        }
    }

}

