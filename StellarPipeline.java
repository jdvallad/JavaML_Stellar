package JavaML_Stellar;

import JavaML_Core.ClassificationPipeline;
import JavaML_Core.CoreConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class StellarPipeline extends ClassificationPipeline {

    public StellarPipeline(CoreConfig config) {
        super(config);
    }

    @Override
    protected void preprocessFile(String inputPath, String outputPath) throws Exception {
        if (!new File(inputPath).exists() || new File(outputPath).exists()) return;
        System.out.println("Preprocessing " + inputPath + " to split color_item column...");
        new File(outputPath).getParentFile().mkdirs();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {
            String line;
            boolean isFirst = true;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",", -1);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < values.length; i++) {
                    if (i == 10) {
                        if (isFirst && !values[i].contains("_")) {
                            sb.append(values[i]).append("_color,").append(values[i]).append("_item,");
                        } else {
                            String[] parts = values[i].split("_", -1);
                            sb.append(parts.length >= 2 ? parts[0] + "," + parts[1] + "," : values[i] + ",unknown,");
                        }
                    } else {
                        sb.append(values[i]).append(",");
                    }
                }
                if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
                writer.println(sb.toString());
                isFirst = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("--- Stellar Classification Engine ---");
        StellarConfig config = new StellarConfig();
        StellarPipeline pipeline = new StellarPipeline(config);
        pipeline.execute();
    }
}