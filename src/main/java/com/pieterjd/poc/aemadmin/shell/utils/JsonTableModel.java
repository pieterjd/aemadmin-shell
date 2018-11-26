package com.pieterjd.poc.aemadmin.shell.utils;

import com.github.tsohr.JSONObject;
import org.springframework.shell.table.TableModel;

import java.util.List;

public class JsonTableModel extends TableModel {
    private List<JSONObject> jsonObjects;

    public JsonTableModel(List<JSONObject> jsonObjects) {
        this.jsonObjects = jsonObjects;
    }

    @Override
    public int getRowCount() {
        return jsonObjects.size();
    }

    @Override
    public int getColumnCount() {
        return jsonObjects.get(0).length();
    }

    @Override
    public Object getValue(int row, int column) {
        String key = jsonObjects.get(0).names().getString(column);
        return jsonObjects.get(row).get(key);
    }
}
