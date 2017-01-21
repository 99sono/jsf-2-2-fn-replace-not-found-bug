package web;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * The controller for the AutoStore Picking screen.
 */
@RequestScoped
@Named("timerController")
public class TimerController {
    private static final Logger LOGGER = Logger.getLogger(TimerController.class.getCanonicalName());

    final String controllerName = "Timer Controller";

    String inputA;
    String inputB;
    String inputC;
    String selectOneButtonValue;

    @PostConstruct
    public void postConstruct() {
        LOGGER.info("timerController - Request scoped bean constructed. ");

    }

    @PreDestroy
    public void preDestroy() {
        LOGGER.info("timerController - Request scoped bean destroyed. ");
    }

    public String getInputA() {
        return inputA;
    }

    public void setInputA(String inputA) {
        this.inputA = inputA;
    }

    public String getInputB() {
        return inputB;
    }

    public void setInputB(String inputB) {
        this.inputB = inputB;
    }

    public String getInputC() {
        return inputC;
    }

    public void setInputC(String inputC) {
        this.inputC = inputC;
    }

    public void nop() {
        LOGGER.info("NOP invoked");
    }

    public String getSelectOneButtonValue() {
        return selectOneButtonValue;
    }

    public void setSelectOneButtonValue(String selectOneButtonValue) {
        this.selectOneButtonValue = selectOneButtonValue;
    }

}