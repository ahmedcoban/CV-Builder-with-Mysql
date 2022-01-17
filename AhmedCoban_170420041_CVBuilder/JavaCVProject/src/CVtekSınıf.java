
import javafx.stage.FileChooser;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class CVtekSınıf extends Application{
  
    public static final String kullanici_adi = "root";
    public static final String parola = "";
    
    public static final String db_ismi = "cv";
    
    public static final String host = "localhost";
            
    public static final int port = 3306;
     
    private Connection con = null;
    
    private Statement statement = null;
    
    private PreparedStatement preparedStatement = null;
    
    public CVtekSınıf(){
        
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi + "?useUnicode=true&characterEncoding=utf8";
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
        } catch (ClassNotFoundException ex) {
            System.out.print("Driver Bulunamadı!");  
        }
                
        try{
            con = DriverManager.getConnection(url ,kullanici_adi, parola);
            System.out.println("Bağlantı Başarılı");
        }
        catch(SQLException ex) {
            System.out.println("Bağlantı Başarısız");
        }   
    }
 
    
  @Override
  public void start(Stage primaryStage) {
    
    Image myImage = new Image(getClass().getResourceAsStream("ikon.jpeg"));
    ImageView imageView = new ImageView(myImage); //file://image//us.gif
    imageView.setFitWidth(200);
    imageView.setFitHeight(200);
    GridPane genelpane = new GridPane();
    GridPane pane = new GridPane();
    GridPane solpane = new GridPane();
    GridPane sagpane = new GridPane();
    GridPane resimpane = new GridPane();
    genelpane.setAlignment(Pos.CENTER);
    
    
    pane.setHgap(5.5);
    pane.setVgap(5.5);
    TextField isim = new TextField();
    TextField soyisim = new TextField();
    TextField cinsiyet = new TextField();
    TextField uyruk = new TextField();
    TextField kimlik = new TextField();
    pane.add(new Label("İsminiz:"), 0, 0);
    pane.add(isim, 1, 0);
    pane.add(new Label("Soyadınız:"), 0, 1);
    pane.add(soyisim, 1, 1);
    pane.add(new Label("Cinsiyet:"), 0, 2);
    pane.add(cinsiyet, 1, 2);
    pane.add(new Label("Uyruk:"), 0, 3);
    pane.add(uyruk, 1, 3);
    pane.add(new Label("Kimlik no:    "), 0, 4);
    pane.add(kimlik, 1, 4);
    Button bt = new Button("Onay");
    pane.add(bt, 1, 5);
    GridPane.setHalignment(bt, HPos.RIGHT);
    Label ustlbl = new Label("");
    pane.add(ustlbl, 0, 5);
    GridPane.setHalignment(ustlbl, HPos.LEFT);
    
    
    
    
    solpane.setHgap(5.5);
    solpane.setVgap(5.5);
    TextField dogumyer = new TextField();
    TextField dogumtarih = new TextField();
    TextField evadresi = new TextField();
    TextField tel = new TextField();
    TextField mail = new TextField();
    solpane.add(new Label("Doğum Yeri:"), 0, 0);
    solpane.add(dogumyer, 1, 0);
    solpane.add(new Label("Tarihi:"), 0, 1);
    solpane.add(dogumtarih, 1, 1);
    solpane.add(new Label("Ev adresi:"), 0, 2);
    solpane.add(evadresi, 1, 2);
    solpane.add(new Label("Tel:"), 0, 3);
    solpane.add(tel, 1, 3);
    solpane.add(new Label("mail:"), 0, 4);
    solpane.add(mail, 1, 4); 
    Button solbt = new Button("Onay");
    solpane.add(solbt, 1, 5);
    GridPane.setHalignment(solbt, HPos.RIGHT);
    Label sollbl = new Label("");
    solpane.add(sollbl, 0, 5);
    GridPane.setHalignment(sollbl, HPos.LEFT);
    

    
    
    sagpane.setHgap(5.5);
    sagpane.setVgap(5.5);
    TextField lise = new TextField();
    TextField uni = new TextField();
    TextField bolum = new TextField();
    TextField deneyim = new TextField();
    TextField referans = new TextField();
    sagpane.add(new Label("Lise:"), 0, 0);
    sagpane.add(lise, 1, 0);
    sagpane.add(new Label("Üniversite:"), 0, 1);
    sagpane.add(uni, 1, 1);
    sagpane.add(new Label("Bölüm:"), 0, 2);
    sagpane.add(bolum, 1, 2);
    sagpane.add(new Label("İş Deneyimi:"), 0, 3);
    sagpane.add(deneyim, 1, 3);
    sagpane.add(new Label("Referans:"), 0, 4);
    sagpane.add(referans, 1, 4);
    Button sagbt = new Button("Onay");
    sagpane.add(sagbt, 1, 5);
    GridPane.setHalignment(sagbt, HPos.RIGHT);
    Label saglbl = new Label("");
    sagpane.add(saglbl, 0, 5);
    GridPane.setHalignment(saglbl, HPos.LEFT);
    
    resimpane.add(imageView, 0, 0);
    GridPane.setHalignment(imageView, HPos.RIGHT);
    Button resimbt= new Button("resim seç");
    Label resimlbl = new Label("");
    resimpane.add(resimlbl, 0, 1);
    GridPane.setHalignment(resimlbl, HPos.LEFT);
    resimpane.add(resimbt, 0, 1);
    GridPane.setHalignment(resimbt, HPos.RIGHT);
    
    
    genelpane.setHgap(25.5);
    genelpane.setVgap(25.5);
    genelpane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    genelpane.add(pane, 0, 0);
    genelpane.add(resimpane, 1, 0);
    genelpane.add(solpane, 0, 1);
    genelpane.add(sagpane, 1, 1);
    
    HBox hBox = new HBox(15);
    hBox.setPadding(new Insets(15, 15, 15, 15));
    hBox.setStyle("-fx-background-color: gold");
    Button CV = new Button("CV Hazırlayıcı");
    Button CVler = new Button("CV'lerim");
    hBox.getChildren().add(CV);
    hBox.getChildren().add(CVler);
    
    VBox vBox = new VBox(15);
    vBox.setPadding(new Insets(15, 5, 5, 5));
    vBox.getChildren().add(genelpane);
    
    HBox h2Box = new HBox(15);
    h2Box.setPadding(new Insets(15, 15, 15, 15));
    h2Box.setStyle("-fx-background-color: green");
    Button temizle = new Button("Temizle");
    Button kaydet = new Button("Kaydet");
    h2Box.getChildren().add(temizle);
    h2Box.getChildren().add(kaydet);
    //h2Box.getChildren().add(image2View);
    h2Box.setAlignment(Pos.BASELINE_RIGHT);
    
    BorderPane borderpane = new BorderPane();

    borderpane.setTop(hBox);
    borderpane.setLeft(vBox);
    borderpane.setBottom(h2Box);
    
    bt.setOnAction(e -> {
        String deneme = "";
        if ( deneme.equals(isim.getText()) || deneme.equals(soyisim.getText()) || deneme.equals(cinsiyet.getText()) || deneme.equals(uyruk.getText()) || deneme.equals(kimlik.getText()) ){
            ustlbl.setText("Boş geçmeyin!");
            ustlbl.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");
        }
        else{
            ustlbl.setText("Tamamlandı");
            ustlbl.setStyle("-fx-text-fill: blue; -fx-font-size: 10px;");
        }
    });
    
    solbt.setOnAction(e -> {
        String deneme = "";
        if ( deneme.equals(dogumyer.getText()) || deneme.equals(dogumtarih.getText()) || deneme.equals(evadresi.getText()) || deneme.equals(tel.getText()) || deneme.equals(mail.getText()) ){
            sollbl.setText("Boş geçmeyin!");
            sollbl.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");
        }
        else{
            sollbl.setText("Tamamlandı");
            sollbl.setStyle("-fx-text-fill: blue; -fx-font-size: 10px;");
        }
        
    });
    
    sagbt.setOnAction(e -> {
        String deneme = "";
        if ( deneme.equals(lise.getText()) || deneme.equals(uni.getText()) || deneme.equals(bolum.getText()) || deneme.equals(deneyim.getText()) || deneme.equals(referans.getText()) ){
            saglbl.setText("Boş geçmeyin!");
            saglbl.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");
        }
        else{
            saglbl.setText("Tamamlandı");
            saglbl.setStyle("-fx-text-fill: blue; -fx-font-size: 10px;");
        }     
    });
    
    temizle.setOnAction(e -> {
        ustlbl.setText("Temizlendi!");
        ustlbl.setStyle("-fx-text-fill: green; -fx-font-size: 10px;");
        sollbl.setText("Temizlendi!");
        sollbl.setStyle("-fx-text-fill: green; -fx-font-size: 10px;");
        saglbl.setText("Temizlendi!");
        saglbl.setStyle("-fx-text-fill: green; -fx-font-size: 10px;");
        isim.setText("");
        soyisim.setText("");
        cinsiyet.setText("");
        uyruk.setText("");
        kimlik.setText("");
        dogumyer.setText("");
        dogumtarih.setText("");
        evadresi.setText("");
        tel.setText("");
        mail.setText("");
        lise.setText("");
        uni.setText("");
        bolum.setText("");
        deneyim.setText("");
        referans.setText("");
    });
    
    resimbt.setOnAction(e -> {
        
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpeg","*.png");
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(imageFilter);

        File file = fc.showOpenDialog(primaryStage);
        if (file != null) {
            Image image1 = new Image(file.toURI().toString());
            
            ImageView ip = new ImageView(image1);
            resimpane.getChildren().clear();
            ip.setFitWidth(200);
            ip.setFitHeight(200);

            resimpane.add(ip, 0, 0);
            GridPane.setHalignment(ip, HPos.RIGHT);   
            resimpane.add(resimlbl, 0, 1);
            GridPane.setHalignment(resimlbl, HPos.LEFT);
            resimpane.add(resimbt, 0, 1);
            GridPane.setHalignment(resimbt, HPos.RIGHT);
            resimlbl.setText("Seçim Başarılı");
            resimlbl.setStyle("-fx-text-fill: blue; -fx-font-size: 10px;");
        }
        else{
            resimlbl.setText("Seçilemedi!");
        resimlbl.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");
        }
    });
    
    kaydet.setOnAction(e -> {
        
        String sorgu = "Insert Into cvlertümü (ad, soyad, cinsiyet, uyruk, kimlik, yer, tarih, adres, tel, email, lise, uni, bölüm, deneyim, referans, eklenecek) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String deneme = "";
        if( deneme.equals(isim.getText()) || deneme.equals(soyisim.getText()) || deneme.equals(cinsiyet.getText()) || deneme.equals(uyruk.getText()) || deneme.equals(kimlik.getText())
                || deneme.equals(dogumyer.getText()) || deneme.equals(dogumtarih.getText()) || deneme.equals(evadresi.getText()) || deneme.equals(tel.getText()) || deneme.equals(mail.getText())               
                        || deneme.equals(lise.getText()) || deneme.equals(uni.getText()) || deneme.equals(bolum.getText()) || deneme.equals(deneyim.getText()) || deneme.equals(referans.getText()) ){
            ustlbl.setText("Kaydedilemedi!");
            ustlbl.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");
            sollbl.setText("Kaydedilemedi!");
            sollbl.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");
            saglbl.setText("Kaydedilemedi!");
            saglbl.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");
        }
        else{
            try {
                String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi + "?useUnicode=true&characterEncoding=utf8";

                try {
                    Class.forName("com.mysql.jdbc.Driver"); 
                } catch (ClassNotFoundException ex) {
                    System.out.print("Driver Bulunamadı!");  
                }

                try{
                    con = DriverManager.getConnection(url ,kullanici_adi, parola);
                    System.out.println("Bağlantı Başarılı");
                }
                catch(SQLException ex) {
                    System.out.println("Bağlantı Başarısız");
                }

                preparedStatement = con.prepareStatement(sorgu);

                preparedStatement.setString(1, isim.getText());
                preparedStatement.setString(2, soyisim.getText());
                preparedStatement.setString(3, cinsiyet.getText());
                preparedStatement.setString(4, uyruk.getText());
                preparedStatement.setString(5, kimlik.getText());
                preparedStatement.setString(6, dogumyer.getText());
                preparedStatement.setString(7, dogumtarih.getText());
                preparedStatement.setString(8, evadresi.getText());
                preparedStatement.setString(9, tel.getText());
                preparedStatement.setString(10, mail.getText());
                preparedStatement.setString(11, lise.getText());
                preparedStatement.setString(12, uni.getText());
                preparedStatement.setString(13, bolum.getText());
                preparedStatement.setString(14, deneyim.getText());
                preparedStatement.setString(15, referans.getText());
                preparedStatement.setString(16, "1");

                preparedStatement.executeUpdate();

                ustlbl.setText("Kaydedildi!");
                ustlbl.setStyle("-fx-text-fill: green; -fx-font-size: 10px;");
                sollbl.setText("Kaydedildi!");
                sollbl.setStyle("-fx-text-fill: green; -fx-font-size: 10px;");
                saglbl.setText("Kaydedildi!");
                saglbl.setStyle("-fx-text-fill: green; -fx-font-size: 10px;");
      
            } 
            catch (SQLException ex) 
            {
            ustlbl.setText("Kaydedilemedi!");
            ustlbl.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");
            sollbl.setText("Kaydedilemedi!");
            sollbl.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");
            saglbl.setText("Kaydedilemedi!");
            saglbl.setStyle("-fx-text-fill: red; -fx-font-size: 10px;");
            }
        }    
    });
    
    Scene scene = new Scene(borderpane);
    
    primaryStage.setTitle("CVPane");
    primaryStage.setScene(scene);
    primaryStage.setWidth(700);
    primaryStage.setHeight(700);
    primaryStage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }
}

