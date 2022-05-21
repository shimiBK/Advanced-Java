

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.util.Map;

public class DictionaryController {
    @FXML private TableView<Map.Entry<String, String>> table;
    @FXML private TableColumn<Map.Entry<String, String>, String> wordCol;
    @FXML private TableColumn<Map.Entry<String, String>, String> defCol;
    @FXML private TextField addWord;
    @FXML private TextField addDef;
    @FXML private TextField deleteWord;
    @FXML private TextField updateWord;
    @FXML private TextField updateDef;
    @FXML private TextField searchWord;
    @FXML private TextField fileNameLoad;
    @FXML private TextField fileNameSave;
    private Dictionary dictionary;
    private Alert showError;
    private Alert showInfo;

    public DictionaryController(){
        dictionary = new Dictionary();
        showError = new Alert(Alert.AlertType.ERROR);
        showInfo = new Alert(Alert.AlertType.INFORMATION);
    }



    @FXML
    private void initialize() {
        table.setPlaceholder(new Label("Currently there are no words to view"));
        wordCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey()));
        defCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue()));
    }
    // updates the dictionary ( mainly after changes )
    @FXML
    private void updateDictionary() {
        table.getItems().clear();
        table.getItems().addAll(dictionary.getDictionary().entrySet());
    }


    @FXML
    protected void add() throws Exception {
        try {
            dictionary.add(addWord.getText(), addDef.getText());
        }
        catch (Exception e){
            showError.setContentText(e.getMessage());
            showError.show();
        }

        updateDictionary();
        addWord.setText("");
        addDef.setText("");
    }

    @FXML
    protected void search() throws Exception {
        try {
            table.getItems().clear();
            table.getItems().addAll(dictionary.search(searchWord.getText()).entrySet());
        }
        catch (Exception e)
        {
            showError.setContentText(e.getMessage());
            showError.show();
        }


    }

    @FXML
    protected void update() throws Exception{
        try {
            dictionary.update(updateWord.getText(), updateDef.getText());
            updateDictionary();
            updateWord.setText("");
            updateDef.setText("");
        }
        catch(Exception e){
            showError.setContentText(e.getMessage());
            showError.show();
        }
    }

    @FXML
    private void clear() {
        searchWord.setText("");
        updateDictionary();
    }

    @FXML
    protected void delete() throws Exception{
        try {
            dictionary.delete(deleteWord.getText());
            updateDictionary();
            deleteWord.setText("");
        }
        catch(Exception e){
            showError.setContentText(e.getMessage());
            showError.show();
        }
    }


    /*
    * saves a dictionary to a file
     */
    @FXML
    private void saveToFile() {
        File f = new File(fileNameSave.getText());
        try {
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(f));
            objOut.writeObject(dictionary);
            objOut.close();
            showInfo.setContentText("Saved phone book under the name " + fileNameSave.getText() + " in the project's directory");
            showInfo.show();
        } catch (IOException e) {
            showError.setContentText(e.getMessage());
            showError.show();
        }
        fileNameSave.setText("");
    }

    /*
    * loads a dictionary from a file
     */
    @FXML
    private void loadFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileNameLoad.getText()));
            dictionary.setDictionary((Dictionary) in.readObject());
            in.close();
        } catch (IOException e) {
            showError.setContentText(e.getMessage());
            showError.show();
        } catch (ClassNotFoundException e) {
            showError.setContentText(e.getMessage());
            showError.show();
        }
        updateDictionary();
        fileNameLoad.setText("");
    }




}