package br.github.vraptor-upload.uploadEdownload

import java.io.File;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.interceptor.download.FileDownload;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

public interface DownloadUpload {

	public abstract void salva(UploadedFile documento, String nome);

	public abstract void deleta(String nome);

	public abstract FileDownload download(String nome);
	
	public abstract File mostra(String nome);

	public void criaCaminhoDosArquivos(ServletContext context);
}
