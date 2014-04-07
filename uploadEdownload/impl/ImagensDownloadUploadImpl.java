package br.github.vraptor-upload.uploadEdownload.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;

import br.com.caelum.vraptor.interceptor.download.FileDownload;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;
import br.gov.ce.funcap.intranet.uploadEdownload.ImagensDownloadUpload;

@Component
public class ImagensDownloadUploadImpl implements ImagensDownloadUpload {
	private File pastaImagens;

	public ImagensDownloadUploadImpl(ServletContext context) {
		criaCaminhoDosArquivos(context);
		String caminhoImagens = context.getRealPath("/WEB-INF/imagens/usuarios");
		pastaImagens = new File(caminhoImagens);
		pastaImagens.mkdir();
	}

	@Override
	public void criaCaminhoDosArquivos(ServletContext context) {
		File caminhoDasImagens = new File(context.getRealPath("/WEB-INF/imagens"));
		if(!caminhoDasImagens.exists()){
			caminhoDasImagens.mkdir();
		}
	}
	
	@Override
	public void salva(UploadedFile documento, String nome) {
		File destino = new File(pastaImagens, nome);
		try {
			IOUtils.copy(documento.getFile(), new FileOutputStream(destino));
			documento.getFile().close();
		} catch (IOException e) {
			throw new RuntimeException("Erro ao copiar imagem", e);
		}
	}

	@Override
	public void deleta(String nome) {
		File file = new File(pastaImagens.getPath() + "/" + nome);
		file.delete();
	}

	@Override
	public FileDownload download(String nome) {
		File arquivo = new File(pastaImagens, nome);
		return new FileDownload(arquivo, "application/download");
	}

	@Override
	public File mostra(String nome) {
		return new File(pastaImagens, nome);
	}

}
