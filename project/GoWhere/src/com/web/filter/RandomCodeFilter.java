package com.web.filter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/randomCode.captcha")
public class RandomCodeFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;

		response.setContentType("image/jpeg");
		int width = 160, height = 60;

		// ����ָ�����ߺ�BufferedImage����
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics(); // �û��ʻ���image��
		Color c = g.getColor(); // ���浱ǰ���ʵ���ɫ�����껭�ʺ�Ҫ�ظ��ֳ�
		g.fillRect(0, 0, width, height);

		char[] ch = "abcdefghjkmnpqrstuvwxyz".toCharArray(); // �漴�������ַ���
		int length = ch.length; // �漴�ַ����ĳ���
		String sRand = ""; // �����漴�������ַ���
		Random random = new Random();
		for (int i = 0; i <= 4; i++) {
			// ��������
			g.setFont(getRandomFont());
			// �漴����0-9������
			String rand = new Character(ch[random.nextInt(length)]).toString();
			sRand += rand;
			// ���������ɫ
			g.setColor(new Color(255, 0, 0));
			g.drawString(rand, 25 * i + 15, 40);
		}
		// �����漴���ŵ�
		for (int i = 0; i < 20; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			g.drawOval(x1, y1, 2, 2);
		}
		g.setColor(c); // �����ʵ���ɫ�����û�ȥ
		g.dispose();

		// ����֤���¼��session
		httprequest.getSession().setAttribute("random-captcha", sRand);

		ServletOutputStream out = httpresponse.getOutputStream();
		ImageIO.write(image, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

	// �����漴������
	private Font getRandomFont() {
		Random random = new Random();
		Font font[] = new Font[5];
		font[0] = new Font("Consolas", Font.PLAIN, 42);
		return font[random.nextInt(1)];
	}
}
