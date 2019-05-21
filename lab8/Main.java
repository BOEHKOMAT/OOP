package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.awt.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;


public class Main extends Application
{
    private ObservableList<Car> autoshow = FXCollections.observableArrayList();
    private Desktop desktop = Desktop.getDesktop();

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        TableView<Car> table = new TableView<>(autoshow);

        TableColumn<Car,String> brandColumn = new TableColumn<>("Марка");
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        brandColumn.setPrefWidth(110);
        table.getColumns().add(brandColumn);

        TableColumn<Car,String> yearColumn = new TableColumn<>("Рік");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("yearOfRelease"));
        yearColumn.setPrefWidth(110);
        table.getColumns().add(yearColumn);

        TableColumn<Car,String> colorColumn = new TableColumn<>("Колір");
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        colorColumn.setPrefWidth(110);
        table.getColumns().add(colorColumn);

        TableColumn<Car,String> speedColumn = new TableColumn<>("Швидкість");
        speedColumn.setCellValueFactory(new PropertyValueFactory<>("maxSpeed"));
        speedColumn.setPrefWidth(110);
        table.getColumns().add(speedColumn);

        TableColumn<Car,String> priceColumn = new TableColumn<>("Ціна");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceColumn.setPrefWidth(110);
        table.getColumns().add(priceColumn);

        Button add = new Button("Добавити");add.setMaxWidth(200);
        Button del = new Button("Оформити продаж");del.setMaxWidth(200);
        Button ser = new Button("Завантажити БД у файл");ser.setMaxWidth(200);
        Button des = new Button("Зчитати БД з файлу");des.setMaxWidth(200);
        Button clr = new Button("Очистити БД");clr.setMaxWidth(200);

        HBox btns = new HBox(add,del,ser,des,clr);

        TextField brand = new TextField();brand.setTooltip(new Tooltip("Brand"));
        TextField year = new TextField();year.setTooltip(new Tooltip("Year"));
        TextField color = new TextField();color.setTooltip(new Tooltip("Color"));
        TextField speed = new TextField();speed.setTooltip(new Tooltip("Speed"));
        TextField price = new TextField();price.setTooltip(new Tooltip("Price"));

        VBox hb = new VBox(brand,year,color,speed,price);

        add.setOnMouseClicked(event ->
        {
            Car car = new Car();
            car.setBrand(brand.getText());
            car.setYearOfRelease(year.getText());
            car.setColor(color.getText());
            car.setMaxSpeed(speed.getText());
            car.setPrice(price.getText());
            autoshow.add(car);
            brand.clear();
            year.clear();
            color.clear();
            speed.clear();
            price.clear();
        });

        del.setOnMouseClicked(event -> {
            Car selectedItem = table.getSelectionModel().getSelectedItem();
            table.getItems().remove(selectedItem);
        });

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        ser.setOnMouseClicked(event -> {
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML","*.xml"));
            File file = fileChooser.showOpenDialog(stage);
            if(file != null)
            {
                try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file.toString()))))
                {
                    encoder.writeObject(autoshow.size());
                    for(int i = 0; i < autoshow.size(); i++)
                    {
                        encoder.writeObject(autoshow.get(i));
                    }
                    encoder.close();
                    System.out.println("БД записано!");
                }
                catch (FileNotFoundException e)
                {
                    System.err.println("Файл не знайдено!");
                }
            }
        });

        des.setOnMouseClicked(event -> {
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML", "*.xml"));
            File file = fileChooser.showOpenDialog(stage);
            if (file != null)
            {
                try(XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file.toString()))))
                {
                    Integer size = (Integer) decoder.readObject();
                    for (int i = 0; i < size; i++)
                    {
                        autoshow.add((Car) decoder.readObject());
                    }
                }
                catch (FileNotFoundException ex)
                {
                    System.err.println("FileNotFound");
                }
            }
        });

        clr.setOnMouseClicked(event -> {
            table.getItems().removeAll();
            autoshow.clear();
        });

        GridPane root = new GridPane();
        ColumnConstraints column = new ColumnConstraints(570,570,Double.MAX_VALUE);
        column.setHgrow(Priority.ALWAYS);
        root.getColumnConstraints().add(column);
        RowConstraints row1 = new RowConstraints(25,25,Double.MAX_VALUE);
        root.getRowConstraints().add(row1);
        RowConstraints row2 = new RowConstraints(75,75,Double.MAX_VALUE);
        row2.setVgrow(Priority.ALWAYS);
        root.getRowConstraints().add(row2);
        RowConstraints row3 = new RowConstraints(400,400,Double.MAX_VALUE);
        row3.setVgrow(Priority.ALWAYS);
        root.getRowConstraints().add(row3);

        root.add(btns,0,0);
        root.add(hb,0,1);
        root.add(table,0,2);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(640);
        stage.setWidth(570);
        stage.setTitle("Автосалон");
        stage.show();

    }
}