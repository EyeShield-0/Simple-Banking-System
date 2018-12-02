// Angel Naguit
// Ayusha Chaudhry 100968449

package javaassignment2;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class JavaAssignment2 extends Application implements EventHandler<ActionEvent> {
    private  Scene home,addScene,depositScene,withdrawScene,listScene,transferScene;
    Stage window;  // represents main Stage globally
    Button btnAddMenu,btnDepositMenu,btnWithdrawMenu,btnTransferMenu,btnListMenu,
            btnAdd,btnHome,btnListHome,btnDeposit,btnDepositHome,btnWithdraw,
            btnWithdrawHome,btnTransfer,btnTransferHome;
    TextField custName,custAccNum,custBalance, depositAccountNum, 
            depositAmount, withdrawAccountNum,withdrawAmount,fromAccNum,toAccNum,
            transferAmount;
    Alert alert = new Alert(AlertType.INFORMATION);
    ListView<String> accList;
    Bank myBank;
    
    @Override
    public void init(){
        myBank = new Bank(10000);
    }
    
    @Override
    public void start(Stage primaryStage){
        
        window = primaryStage;
        window.setTitle("EN Bank");
        window.getIcons().add(new Image(JavaAssignment2.class.getResourceAsStream("icon.png")));
        window.resizableProperty().setValue(Boolean.FALSE);
        
        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image(JavaAssignment2.class.getResourceAsStream("icon.png")));
        ImageView icon = new ImageView("javaassignment2/icon.png");
        icon.setFitHeight(65);
        icon.setFitWidth(65);
        alert.getDialogPane().setGraphic(icon);
 
        // setting up Home Scene
        GridPane homeLayout = new GridPane();
        homeLayout.setPadding(new Insets(10,10,10,10));
        homeLayout.setVgap(8);
        homeLayout.setHgap(10);
        Label lblHomeMenu = new Label("Welcome to EN Bank. Please select an option from below. ");
        GridPane.setConstraints(lblHomeMenu, 0, 0);
        btnAddMenu = new Button("Add");btnAddMenu.setOnAction(this);btnAddMenu.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(btnAddMenu, 0, 1);
        btnDepositMenu = new Button("Deposit");btnDepositMenu.setOnAction(this);btnDepositMenu.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(btnDepositMenu, 0, 2);
        btnWithdrawMenu = new Button("Withdraw");btnWithdrawMenu.setOnAction(this);btnWithdrawMenu.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(btnWithdrawMenu, 0, 3);
        btnTransferMenu = new Button("Transfer");btnTransferMenu.setOnAction(this);btnTransferMenu.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(btnTransferMenu, 0, 4);
        btnListMenu = new Button("List");btnListMenu.setOnAction(this);btnListMenu.setMaxWidth(Double.MAX_VALUE);
        GridPane.setConstraints(btnListMenu, 0, 5);
        homeLayout.setAlignment(Pos.BOTTOM_CENTER);
        homeLayout.getChildren().addAll(lblHomeMenu,btnAddMenu,btnDepositMenu,btnWithdrawMenu,btnTransferMenu,btnListMenu);
        home = new Scene(homeLayout,500,500);
        homeLayout.getStylesheets().add("javaassignment2/mystyle.css");

        
        // setting up Add Scene
        GridPane addLayout = new GridPane();
        addLayout.setPadding(new Insets(10,10,10,10));
        addLayout.setVgap(8);
        addLayout.setHgap(10);
        Label lblName =new Label("Name: ");
        GridPane.setConstraints(lblName, 0, 0);
        custName = new TextField(); 
        GridPane.setConstraints(custName, 1, 0);
        Label lblAccNum = new Label("Account #: ");
        GridPane.setConstraints(lblAccNum, 0, 1);
        custAccNum = new TextField(); 
        GridPane.setConstraints(custAccNum, 1, 1);
        Label lblBalance = new Label("Balance: ");
        GridPane.setConstraints(lblBalance, 0, 2);
        custBalance = new TextField();
        GridPane.setConstraints(custBalance, 1, 2);
        btnAdd = new Button("Add Account");btnAdd.setOnAction(this);
        GridPane.setConstraints(btnAdd, 1, 3);
        btnHome = new Button("Back");btnHome.setOnAction(this);
        GridPane.setConstraints(btnHome, 1, 4);
        addLayout.setAlignment(Pos.BOTTOM_CENTER);
        addLayout.getChildren().addAll(lblName,custName,lblAccNum,custAccNum,lblBalance,custBalance,btnAdd,btnHome);
        addScene = new Scene(addLayout,500,500);
        addLayout.getStylesheets().add("javaassignment2/mystyle.css");
        
        // setting up Deposit Scene 
        GridPane depositLayout = new GridPane();
        depositLayout.setPadding(new Insets(10,10,10,10));
        depositLayout.setVgap(8);
        depositLayout.setHgap(10);
        Label lblDAccountNum = new Label("Account #: ");
        GridPane.setConstraints(lblDAccountNum, 0, 0);
        depositAccountNum = new TextField();
        GridPane.setConstraints(depositAccountNum, 1, 0);
        Label lblDepositAmount = new Label("Deposit Amount: ");
        GridPane.setConstraints(lblDepositAmount, 0, 1);
        depositAmount = new TextField();
        GridPane.setConstraints(depositAmount, 1, 1);
        btnDeposit = new Button("Deposit");btnDeposit.setOnAction(this);
        GridPane.setConstraints(btnDeposit, 1, 2);
        btnDepositHome = new Button("Back");btnDepositHome.setOnAction(this);
        GridPane.setConstraints(btnDepositHome, 1, 3);
        depositLayout.setAlignment(Pos.BOTTOM_CENTER);
        depositLayout.getChildren().addAll(lblDAccountNum,depositAccountNum,lblDepositAmount,depositAmount,btnDeposit,btnDepositHome);
        depositScene = new Scene(depositLayout,500,500);
        depositLayout.getStylesheets().add("javaassignment2/mystyle.css");
        
        // setting up Withdraw Scene
        GridPane withdrawLayout = new GridPane();
        withdrawLayout.setPadding(new Insets(10,10,10,10));
        withdrawLayout.setVgap(8);
        withdrawLayout.setHgap(10);
        Label lblWAccountNum = new Label("Account #: ");
        GridPane.setConstraints(lblWAccountNum, 0, 0);
        withdrawAccountNum = new TextField();
        GridPane.setConstraints(withdrawAccountNum, 1, 0);
        Label lblWithdrawAmount = new Label("Withdrawal Amount: ");
        GridPane.setConstraints(lblWithdrawAmount, 0, 1);
        withdrawAmount = new TextField();
        GridPane.setConstraints(withdrawAmount, 1, 1);
        btnWithdraw = new Button("Withdraw");btnWithdraw.setOnAction(this);
        GridPane.setConstraints(btnWithdraw, 1, 2);
        btnWithdrawHome = new Button("Back");btnWithdrawHome.setOnAction(this);
        GridPane.setConstraints(btnWithdrawHome, 1, 3);
        withdrawLayout.setAlignment(Pos.BOTTOM_CENTER);
        withdrawLayout.getChildren().addAll(lblWAccountNum,withdrawAccountNum,lblWithdrawAmount,withdrawAmount,btnWithdraw,btnWithdrawHome);
        withdrawScene = new Scene(withdrawLayout,500,500);
        withdrawLayout.getStylesheets().add("javaassignment2/mystyle.css");
        
        // Setting up Transfer Scene
        GridPane transferLayout = new GridPane();
        transferLayout.setPadding(new Insets(10,10,10,10));
        transferLayout.setVgap(8);
        transferLayout.setHgap(10);
        Label lblFromAccNum = new Label("From Account #: ");
        GridPane.setConstraints(lblFromAccNum, 0, 0);
        fromAccNum = new TextField();
        GridPane.setConstraints(fromAccNum, 1, 0);
        Label lblToAccNum = new Label("To Account #: ");
        GridPane.setConstraints(lblToAccNum, 0, 1);
        toAccNum = new TextField();
        GridPane.setConstraints(toAccNum, 1, 1);
        Label lblTransferAmount = new Label("Transfer Amount: ");
        GridPane.setConstraints(lblTransferAmount, 0, 2);
        transferAmount = new TextField();
        GridPane.setConstraints(transferAmount, 1, 2);
        btnTransfer = new Button("Transfer");btnTransfer.setOnAction(this);
        GridPane.setConstraints(btnTransfer, 1, 3);
        btnTransferHome = new Button("Back");btnTransferHome.setOnAction(this);
        GridPane.setConstraints(btnTransferHome, 1, 4);
        transferLayout.setAlignment(Pos.BOTTOM_CENTER); 
        transferLayout.getChildren().addAll(lblFromAccNum,fromAccNum,lblToAccNum,toAccNum,lblTransferAmount,transferAmount,btnTransfer,btnTransferHome);
        transferScene = new Scene(transferLayout,500,500);
        transferLayout.getStylesheets().add("javaassignment2/mystyle.css");
        
        // setting up List Scene
        Label lblShow = new Label("List of accounts...");
        accList = new ListView<>();
        btnListHome = new Button("Back");btnListHome.setOnAction(this);btnListHome.setMaxWidth(Double.MAX_VALUE);
        VBox listLayout = new VBox();
        listLayout.getChildren().addAll(lblShow,accList,btnListHome);
        listScene = new Scene (listLayout,500,500);
        listLayout.getStylesheets().add("javaassignment2/mystyle.css");
         
        window.setScene(home);
        window.show();
    }
    
    @Override
    public void stop(){
        
    }
    
    
    @Override
    public void handle(ActionEvent e){
        
        if (e.getSource()==btnAddMenu){
            custName.setText("");
            custAccNum.setText("");
            custBalance.setText("");
            window.setScene(addScene);
        }
        
        if (e.getSource()==btnDepositMenu){
            depositAccountNum.setText("");
            depositAmount.setText("");
            window.setScene(depositScene);
        }
        
        if (e.getSource()==btnWithdrawMenu){
            withdrawAccountNum.setText("");
            withdrawAmount.setText("");
            window.setScene(withdrawScene);
        }
        
        if (e.getSource()==btnTransferMenu){
            fromAccNum.setText("");
            toAccNum.setText("");
            transferAmount.setText("");
            window.setScene(transferScene);
        }
        
        if (e.getSource()==btnListMenu){
            accList.getItems().clear();
            accList.getItems().addAll(myBank.printAccounts());
            window.setScene(listScene);
        }
        
        if (e.getSource()==btnHome||e.getSource()==btnListHome||e.getSource()==btnDepositHome||e.getSource()==btnWithdrawHome||e.getSource()==btnTransferHome){
            window.setScene(home);
        }
        
        if(e.getSource()==btnAdd){
            try{
                String owner = custName.getText();
                long accNum = Long.parseLong(custAccNum.getText());
                double balance = Double.parseDouble(custBalance.getText());
                if((myBank.addAccount(owner,accNum,balance)) && (!(custName.getText().trim().isEmpty()))){
                    alert.setTitle("EN Bank");
                    alert.setHeaderText("Account added successfully!");
                    alert.setContentText("Thank you for banking with us, \nenjoy your day!");
                    alert.showAndWait();
                    custName.setText("");
                    custAccNum.setText("");
                    custBalance.setText("");
                }
                else{
                    alert.setTitle("EN Bank");
                    alert.setHeaderText("Account not added...");
                    alert.setContentText("Account number already exists or \nCustomer name feild is empty or \ninput is negative. ");
                    alert.showAndWait();
                }
            }
            catch(NumberFormatException er){
                alert.setTitle("EN Bank");
                alert.setHeaderText("Account not added...");
                alert.setContentText("Please enter a numerical value for account number and balance. ");
                alert.showAndWait();
            }
        }
        
        if(e.getSource()==btnDeposit){
            try{
                long depAccNum = Long.parseLong(depositAccountNum.getText());
                double depAmount = Double.parseDouble(depositAmount.getText());
                if(myBank.depositAccount(depAccNum,depAmount)){
                    alert.setTitle("EN Bank");
                    alert.setHeaderText("Deposit successful!");
                    alert.setContentText("Thank you for banking with us, \nenjoy your day!");
                    alert.showAndWait();  
                    depositAccountNum.setText("");
                    depositAmount.setText("");
                }
                else{
                    alert.setTitle("EN Bank");
                    alert.setHeaderText("Deposit unsuccessful...");
                    alert.setContentText("Account number does not exist or\n input is negative. ");
                    alert.showAndWait();                
                }
            }
            catch(NumberFormatException er){
                alert.setTitle("EN Bank");
                alert.setHeaderText("Account not added...");
                alert.setContentText("Please enter a numerical value for account number and balance. ");
                alert.showAndWait();            
            }
        }
        
        if(e.getSource()==btnWithdraw){
            try{
                long withAccNum = Long.parseLong(withdrawAccountNum.getText()); 
                double withAmount = Double.parseDouble(withdrawAmount.getText());
                if(myBank.withdrawAccount(withAccNum,withAmount)){
                    alert.setTitle("EN Bank");
                    alert.setHeaderText("Withdrawal successful!");
                    alert.setContentText("Thank you for banking with us, \nenjoy your day!");
                    alert.showAndWait(); 
                    withdrawAccountNum.setText("");
                    withdrawAmount.setText("");
                }
                else{
                    alert.setTitle("EN Bank");
                    alert.setHeaderText("Withdrawal unsuccessful...");
                    alert.setContentText("Account number does not exist or\n input is negative. ");
                    alert.showAndWait();                
                }
            }
            catch(NumberFormatException er){
                alert.setTitle("EN Bank");
                alert.setHeaderText("Withdrawal unsuccessful...");
                alert.setContentText("Please enter a numerical value for account number and balance. ");
                alert.showAndWait();             
            }
        }
        
        if(e.getSource()==btnTransfer){
            try{
                long fAccNum = Long.parseLong(fromAccNum.getText());
                long tAccNum = Long.parseLong(toAccNum.getText());
                double amount = Double.parseDouble(transferAmount.getText());
                if(myBank.transfer(fAccNum, tAccNum, amount)){
                    alert.setTitle("EN Bank");
                    alert.setHeaderText("Transfer successful!");
                    alert.setContentText("Thank you for banking with us, \nenjoy your day!");
                    alert.showAndWait();  
                    fromAccNum.setText("");
                    toAccNum.setText("");
                    transferAmount.setText("");
                }
                else{
                alert.setTitle("EN Bank");
                alert.setHeaderText("Transfer unsuccessful...");
                alert.setContentText("Account number does not exist or\n input is negative. ");
                alert.showAndWait();                
                }
            }
            catch(NumberFormatException er){
                alert.setTitle("EN Bank");
                alert.setHeaderText("Transfer unsuccessful...");
                alert.setContentText("Please enter a numerical value for account number and balance. ");
                alert.showAndWait();            
            }
        }
    }
    
    public static void main(String[] args) {
      launch(args);
    }
    
}

