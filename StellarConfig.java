package JavaML_Stellar;

import JavaML_Core.CoreConfig;

public class StellarConfig extends CoreConfig {

    public StellarConfig() {
        this.displayCount = 50;
        this.originalTrainPath = "./JavaML_Stellar/data/train.csv";
        this.originalTestPath = "./JavaML_Stellar/data/test.csv";
        this.rawTestPath = "./JavaML_Stellar/data/test_processed.csv";
        this.rawSubmissionPath = "./JavaML_Stellar/data/submission.csv";
        this.submissionHeader = "id,class";

        this.isClassification = true;
        this.hasHeader = true;

        this.batchSize = 128;
        this.learningRate = 0.005;
        this.decayRate = 0.995;
        this.epochs = 100;

        // --- SPLIT SETTINGS ---
        this.randomSeed = 42L; // The Answer to the Ultimate Question (ensures reproducibility)
        this.trainSplit = 0.80; // 80% Train
        this.validationSplit = 0.10; // 10% Validate

        // File Paths
        this.rawSourcePath = "./JavaML_Stellar/data/train_processed.csv";
        this.trainPath = "./JavaML_Stellar/data/train_split.csv";
        this.validationPath = "./JavaML_Stellar/data/validate_split.csv";
        this.testPath = "./JavaML_Stellar/data/test_split.csv";
        this.loadModelPath = "./JavaML_Stellar/models/stellar_model.ser";
        this.saveModelPath = "./JavaML_Stellar/models/stellar_model.ser";

        // Architecture: Input -> 512 -> 256 -> 128 -> Output
        // (0s are placeholders updated by scanDataSchema)
        this.nodes = new int[] { 0, 512, 256, 128, 0 }; 
        this.activations = new String[] { "leakyRelu", "leakyRelu", "leakyRelu", "softmax" };
        this.costFunction = "logLoss";

    }
}