package com.pieterjd.poc.aemadmin.shell.commands;


import com.pieterjd.aemadmin.config.ConfigFactory;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ConfigCommands {
    @ShellMethod("connect to an AEM instance")
    public void connect(String baseUrl,String userName,String password,@ShellOption(defaultValue = "4502") String port){
        ConfigFactory.getConfig().setProperty("baseUrl",baseUrl);
        ConfigFactory.getConfig().setProperty("userName",userName);
        ConfigFactory.getConfig().setProperty("password",password);
        ConfigFactory.getConfig().setProperty("port",port);
    }

    @ShellMethod("connect to local author")
    public void connectLocalAuthor(){
        connect("http://localhost","admin","admin","4502");
    }
}
