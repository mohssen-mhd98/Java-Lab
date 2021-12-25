package calcAdvance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * Created by mohsen on 12/24/2021.
 */
public class Controller {

    //Import PreProcessor
    StringCalcProcessor engine = new StringCalcProcessor();

    @FXML
    private Text output;
    @FXML
    private Text smallText;

    private boolean start = true;
    private boolean eqSelect = false;


    // numbers and sinusoid functions
    @FXML
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
//        int len = smallText.getText().length();
//        char ch = value.charAt(len-1);
//        String tmp;
//        System.out.println(value.charAt(len-1));
//        if (ch == 'n' || ch == 's' || ch == 't'){
//            double radians = Math.toRadians(Integer.parseInt(ou.getText()));
//            double cosValue = Math.cos(radians);
//        }

        output.setText(output.getText() + value);

    }


    @FXML
    private void processOperator(ActionEvent event) throws ScriptException {
        String value = ((Button)event.getSource()).getText();

        if(eqSelect){
            smallText.setText(output.getText());
            output.setText("");
            eqSelect = false;
        }

        if (!"=".equals(value)) {
            if ("A/C".equals(value)) {
                smallText.setText("");
                output.setText("");
            } else if ("^".equals(value)){
                //String hString = output.getText();
                smallText.setText(smallText.getText() + output.getText() + "^");
                output.setText("");
                //powSelect = true;

            } else if ("×".equals(value)){

//                if (powSelect){
//                    char[] tmp = (smallText.getText() + output.getText()).toCharArray();
//                    String x = "";
//                    String powInp;
//                    int i = tmp.length - 1;
//                    System.out.println(Arrays.toString(tmp) + i);
//                    while (tmp[i] != '^'){
//                        x += String.valueOf(tmp[i]);
//                        System.out.println(tmp[i] + "---" + x);
//                        i--;
//                    }
//                    powInp = "Math.pow" + "(" + tmp[i-1] + "," + x + ")";
//                    System.out.println(powInp + x);
//
//                    powSelect = false;
//                }

                smallText.setText(smallText.getText() + output.getText() + "*");
                output.setText("");


            } else if ("÷".equals(value)){
                smallText.setText(smallText.getText() + output.getText() + "/");
                output.setText("");

            } else {
                System.out.println(value);
                smallText.setText(smallText.getText() + output.getText() + value);
                output.setText("");
            }
        } else {
            smallText.setText(smallText.getText()+output.getText());
            try {
                String combi = smallText.getText();
                System.out.println(combi);
                BigDecimal holderOutput = new BigDecimal(engine.eval(combi));
                holderOutput = holderOutput.setScale(1, RoundingMode.HALF_UP);
                output.setText(holderOutput.toString());
                eqSelect = true;
            } catch (Exception e){
                output.setText("syntax error");
                System.out.println(e);
            }
////            ScriptEngineManager mgr = new ScriptEngineManager();
////            ScriptEngine engine = mgr.getEngineByName("JavaScript");
//            String inpText = smallText.getText()+output.getText();
//            smallText.setText(inpText);
//            // System.out.println(inpText.toCharArray());
//            try {
//                // BigDecimal holderOutput = new BigDecimal(engine.eval(smallText.getText()));
////              holderOutput = holderOutput.setScale(1, RoundingMode.HALF_UP);
//                //output.setText(engine.eval("2**5").toString());
//                ScriptEngineManager mgr = new ScriptEngineManager();
//                ScriptEngine engine = mgr.getEngineByName("JavaScript");
//                String infix = "(2**2+5*2+3)%13";
//                Double F = (Double) engine.eval(infix);
//                System.out.println(F);
//            } catch (ScriptException e) {
//                output.setText("syntax error");
//                System.out.println(e);
//            }

        }
    }
}
