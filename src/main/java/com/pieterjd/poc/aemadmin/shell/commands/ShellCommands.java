package com.pieterjd.poc.aemadmin.shell.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellCommands {
    @ShellMethod("Returns a node for the given path")
    public int getNode(String path){
        return 0;
    }
}
