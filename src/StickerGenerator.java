import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class StickerGenerator {

    App app;

    public void create(InputStream inputStream, String nomeArquivo) throws Exception {

        BufferedImage imagemOriginal =
                ImageIO.read(inputStream);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem =
                new BufferedImage(largura,novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        String texto = "TOPZERA";
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D retangulo = fontMetrics.getStringBounds(texto,graphics);
        int larguraTexto = (int) retangulo.getWidth();
        graphics.drawString(texto , (largura - larguraTexto)/2, novaAltura - 100);

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }


}

