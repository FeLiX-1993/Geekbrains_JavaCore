import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorButtonListener implements ActionListener {

    private JTextField outField;
    private StringBuilder sb;
    private ScriptEngine scriptEngine;

    public CalculatorButtonListener(JTextField outField) {
        this.outField = outField;
        this.sb = new StringBuilder();
        this.scriptEngine = new ScriptEngineManager().getEngineByName("Nashorn");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton jButton = (JButton) e.getSource();
        String jButtonText = jButton.getText();
        String outFieldText = outField.getText();
        String val;


        if (jButtonText.equals("=")) {
            try {
                val = scriptEngine.eval(outFieldText).toString();
            } catch (ScriptException scriptException) {
                JOptionPane.showMessageDialog(outField,
                        scriptException.getMessage(),
                        "Calculating error",
                        JOptionPane.WARNING_MESSAGE);
                val = outFieldText;
            }
        } else if (jButtonText.equals("C")){
            val = "";
        } else {
            val = sb.append(outFieldText).append(jButton.getText()).toString();
        }

        outField.setText(val);
        sb.setLength(0);
    }
}
