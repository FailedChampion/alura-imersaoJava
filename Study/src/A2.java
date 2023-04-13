import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

// Geradora de Figurinhas
public class A2 {
    public void cria(InputStream is, String nomeArquivo, String textoEscrito) throws Exception {
        // leitura da imagem
        BufferedImage imagemOriginal =  ImageIO.read(is);

        // cria nova imagem em memória com transparência e com tamanho novo
        int altura = imagemOriginal.getHeight();
        int largura = imagemOriginal.getWidth();
        int novaAltura = altura + 200;
        int metade = 50 * largura / 100;
        BufferedImage novaImagem =  new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar imagem original pra nova imagem (em memória)
        Graphics2D grap = (Graphics2D) novaImagem.getGraphics();
        grap.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        Font fonte;
        if (largura <= 1000) {
            fonte = new Font("Comic Sans MS", Font.BOLD, 35);
        } else {
            fonte = new Font("Comic Sans MS", Font.BOLD, 75);
        }
        AffineTransform transform = grap.getTransform();
        FontRenderContext frc = grap.getFontRenderContext();
        FontMetrics fm = grap.getFontMetrics();
        transform.translate(metade - fm.stringWidth(textoEscrito), novaAltura - 100);
        grap.transform(transform);
        grap.setFont(fonte);
        grap.setColor(Color.BLACK);


        // escrever uma frase na nova imagem
        TextLayout tl = new TextLayout(textoEscrito, grap.getFont(), frc);
        Shape shape = tl.getOutline(null);
        grap.setStroke(new BasicStroke(10f));
        grap.draw(shape);
        grap.setColor(Color.YELLOW);
        grap.fill(shape);

        // escrever a nova imagem em um arquivo
        File criaImagem = new File("saida/" + nomeArquivo);
        boolean criaPasta = criaImagem.mkdirs();
        ImageIO.write(novaImagem, "png", criaImagem);
    }
}



