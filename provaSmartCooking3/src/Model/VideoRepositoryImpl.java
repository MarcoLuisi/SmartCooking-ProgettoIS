package Model;

import DAO.MySQLVideoDAO;

import java.util.List;

public class VideoRepositoryImpl implements VideoRepository{

    private MySQLVideoDAO mySQLVideoDAO;

    public VideoRepositoryImpl(){
        mySQLVideoDAO = new MySQLVideoDAO();
    }

    @Override
    public List<Video> getList() {
        return mySQLVideoDAO.getAllVideo();
    }

    @Override
    public List<Video> getListByCategoria(String categoria) {
        List<Video> listVideo = mySQLVideoDAO.getVideoByCategoria(categoria);
        return listVideo;
    }

    @Override
    public List<Video> getListByInsegnante(String nome, String cognome) {
        return mySQLVideoDAO.getVideoByInsegnante(nome, cognome);
    }

    @Override
    public int addVideo(String titolo, String categoria, boolean gratuito,
                       int id_insegnante, String email_admin) {
        return mySQLVideoDAO.createVideo(titolo, categoria, gratuito, id_insegnante, email_admin);
    }

    @Override
    public boolean removeVideo(String titolo) {
        return mySQLVideoDAO.deleteVideo(titolo);
    }

	@Override
	public Video getVideo(String titolo) {
		// TODO Auto-generated method stub
		return mySQLVideoDAO.getVideo(titolo);
	}

	@Override
	public boolean modifyVideo(int id_video, String titolo, String categoria, boolean gratuito,
            int id_insegnante, String email_admin) {
		// TODO Auto-generated method stub
		return mySQLVideoDAO.updateVideo(id_video, titolo, categoria, gratuito, id_insegnante, email_admin);
	}

	@Override
	public List<Video> getListByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return mySQLVideoDAO.getVideoByKeyword(keyword);
	}
}
