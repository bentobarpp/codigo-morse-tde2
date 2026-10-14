import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

// Bonus: reproduz o codigo morse em som (ponto = beep curto, traco = beep longo).
public class MorseSoundPlayer {

    private static final float SAMPLE_RATE = 8000f;
    private static final double TONE_FREQUENCY = 700.0;
    private static final int DOT_DURATION_MS = 150;
    private static final int DASH_DURATION_MS = DOT_DURATION_MS * 3;
    private static final int SYMBOL_GAP_MS = DOT_DURATION_MS;
    private static final int LETTER_GAP_MS = DOT_DURATION_MS * 3;

    public void playMorseWord(String morseWord) throws LineUnavailableException {
        AudioFormat audioFormat = new AudioFormat(SAMPLE_RATE, 8, 1, true, false);
        SourceDataLine audioLine = AudioSystem.getSourceDataLine(audioFormat);
        audioLine.open(audioFormat);
        audioLine.start();

        String[] morseGroups = morseWord.trim().split("/");
        for (String morseGroup : morseGroups) {
            String[] morseLetters = morseGroup.trim().split("\\s+");
            for (String morseLetter : morseLetters) {
                for (char symbol : morseLetter.toCharArray()) {
                    if (symbol == '.') {
                        playTone(audioLine, DOT_DURATION_MS);
                    } else if (symbol == '-') {
                        playTone(audioLine, DASH_DURATION_MS);
                    }
                    playSilence(audioLine, SYMBOL_GAP_MS);
                }
                playSilence(audioLine, LETTER_GAP_MS);
            }
        }

        audioLine.drain();
        audioLine.close();
    }

    private void playTone(SourceDataLine audioLine, int durationMs) {
        byte[] toneBuffer = buildBuffer(durationMs);
        for (int sampleIndex = 0; sampleIndex < toneBuffer.length; sampleIndex++) {
            double angle = 2.0 * Math.PI * sampleIndex * TONE_FREQUENCY / SAMPLE_RATE;
            toneBuffer[sampleIndex] = (byte) (Math.sin(angle) * 100);
        }
        audioLine.write(toneBuffer, 0, toneBuffer.length);
    }

    private void playSilence(SourceDataLine audioLine, int durationMs) {
        byte[] silenceBuffer = buildBuffer(durationMs);
        audioLine.write(silenceBuffer, 0, silenceBuffer.length);
    }

    private byte[] buildBuffer(int durationMs) {
        int totalSamples = (int) (SAMPLE_RATE * durationMs / 1000);
        return new byte[totalSamples];
    }
}
