package com.pieterjd.poc.aemadmin.shell.commands;

import com.pieterjd.aemadmin.command.StatusBundlesCommand;
import com.pieterjd.aemadmin.command.packmgr.ListPackagesCommand;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;

@ShellComponent
public class BundleCommands {
    @ShellMethod("List all bundles")
    public String listBundles() throws IOException {
        StatusBundlesCommand c = new StatusBundlesCommand();
        c.execute();
        return c.getHttpResponseAsJSON().toString(1);
    }
}
