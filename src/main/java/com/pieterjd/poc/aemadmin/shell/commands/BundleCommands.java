package com.pieterjd.poc.aemadmin.shell.commands;

import com.github.tsohr.JSONArray;
import com.github.tsohr.JSONObject;
import com.pieterjd.aemadmin.command.StatusBundlesCommand;
import com.pieterjd.poc.aemadmin.shell.utils.JsonTableModel;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class BundleCommands {
    @ShellMethod("List all bundles")
    public Table listBundles() throws IOException {
        StatusBundlesCommand c = new StatusBundlesCommand();
        c.execute();
        //get jsonobject
        List<JSONObject> bundles = new ArrayList<>();
        JSONArray data = c.getHttpResponseAsJSON().getJSONArray("data");
        for(int i=0;i<data.length();i++){
            bundles.add(data.getJSONObject(i));
        }
        TableModel model = new JsonTableModel(bundles);
        TableBuilder builder = new TableBuilder(model);
        return builder.build();
        //return c.getHttpResponseAsJSON().toString(1);
    }
}
