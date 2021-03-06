package com.pieterjd.poc.aemadmin.shell.commands;

import com.pieterjd.aemadmin.command.packmgr.BuildPackageCommand;
import com.pieterjd.aemadmin.command.packmgr.DownloadPackageCommand;
import com.pieterjd.aemadmin.command.packmgr.InstallPackageCommand;
import com.pieterjd.aemadmin.command.packmgr.ListPackagesCommand;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;

@ShellComponent
public class PackageCommands {
    @ShellMethod("List all packages")
    public String listPackages() throws IOException {
        ListPackagesCommand c = new ListPackagesCommand();
        c.execute();
        return c.getHttpResponseAsJSON().toString(1);
    }

    @ShellMethod("Installs a package")
    public String installPackage(String  packageName) throws IOException {
        InstallPackageCommand c = new InstallPackageCommand(packageName);
        c.execute();
        return c.getHttpResponseAsJSON().toString(1);
    }

    @ShellMethod("Builds a package")
    public String buildPackage(String  packageName) throws IOException {
        BuildPackageCommand c = new BuildPackageCommand(packageName);
        c.execute();
        return c.getHttpResponseAsString();
    }

    @ShellMethod("Downloads a package")
    public String downloadPackage(String  packageName,String fileName) throws IOException {
        DownloadPackageCommand c = new DownloadPackageCommand(packageName,fileName);
        c.execute();
        return c.getHttpResponseAsString();
    }
}
