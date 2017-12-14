package ldh.form.view.control;

import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import ldh.form.model.structure.MultiSelectionField;

public class SimpleListViewControl<V> extends SimpleControl<MultiSelectionField<V>> {

    private Label fieldLabel;
    private ListView<String> listView = new ListView<>();

    private boolean preventUpdate;

    @Override
    public void initializeParts() {
        super.initializeParts();

        getStyleClass().add("simple-listview-control");

        fieldLabel = new Label(field.labelProperty().getValue());

        listView.setItems(field.getItems());
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for (int i = 0; i < field.getItems().size(); i++) {
            if (field.getSelection().contains(field.getItems().get(i))) {
                listView.getSelectionModel().select(i);
            } else {
                listView.getSelectionModel().clearSelection(i);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void layoutParts() {
        super.layoutParts();

        int columns = field.getSpan();

        listView.setPrefHeight(200);

        add(fieldLabel, 0,0,2,1);
        add(listView, 2, 0, columns - 2, 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setupBindings() {
        super.setupBindings();

        fieldLabel.textProperty().bind(field.labelProperty());
        listView.disableProperty().bind(field.editableProperty().not());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setupValueChangedListeners() {
        super.setupValueChangedListeners();

        field.itemsProperty().addListener((observable, oldValue, newValue) -> listView.setItems(field.getItems()));

        field.selectionProperty().addListener((observable, oldValue, newValue) -> {
            if (preventUpdate) {
                return;
            }

            preventUpdate = true;

            for (int i = 0; i < field.getItems().size(); i++) {
                if (field.getSelection().contains(field.getItems().get(i))) {
                    listView.getSelectionModel().select(i);
                } else {
                    listView.getSelectionModel().clearSelection(i);
                }
            }

            preventUpdate = false;
        });

        field.errorMessagesProperty().addListener((observable, oldValue, newValue) -> toggleTooltip(listView));
        field.tooltipProperty().addListener((observable, oldValue, newValue) -> toggleTooltip(listView));
        listView.focusedProperty().addListener((observable, oldValue, newValue) -> toggleTooltip(listView));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setupEventHandlers() {
        listView.setOnMouseEntered(event -> toggleTooltip(listView));
        listView.setOnMouseExited(event -> toggleTooltip(listView));

        listView.getSelectionModel().getSelectedIndices().addListener((ListChangeListener<Integer>) c -> {
            if (preventUpdate) {
                return;
            }

            preventUpdate = true;

            for (int i = 0; i < listView.getItems().size(); i++) {
                if (listView.getSelectionModel().getSelectedIndices().contains(i)) {
                    field.select(i);
                } else {
                    field.deselect(i);
                }
            }

            preventUpdate = false;
        });
    }

}
