package DAO;

import Model.Admin;


import Model.Utente;
import Model.Video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLVideoDAO implements VideoDAO {

    /** La query per l'inserimento di un nuovo video */
    private static final String CREATE_QUERY = "INSERT INTO video(titolo, categoria, gratuito, " +
            "id_insegnante, email_admin) VALUES (?,?,?,?,?)";

    
    /** La query per la ricerca del video in base all'insegnante */
    private static final String READ_QUERY_INSEGNANTE = "SELECT * FROM video v, insegnante i, amministratore a " +
            "WHERE v.id_insegnante=i.id_insegnante and v.email_admin = a.email and i.nome=? and i.cognome=?";
            
     /* La query per la ricerca del video in base a keyword */
     private static final String READ_QUERY_KEYWORD = "SELECT * FROM video WHERE MATCH(titolo) AGAINST(?)";

    /** La query per la ricerca del video in base alla categoria */
    private static final String READ_QUERY_CATEGORIA = "SELECT * FROM video v, insegnante i, amministratore a " +
            "WHERE v.id_insegnante=i.id_insegnante and v.email_admin = a.email and v.categoria=? ";

    /** La query per la lettura di tutti i video  */
    private static final String READ_QUERY_ALL = "SELECT * FROM video v, insegnante i, amministratore a " +
            "WHERE v.id_insegnante=i.id_insegnante and v.email_admin = a.email order by v.id_video ";


    private static final String DELETE_QUERY = "DELETE FROM video WHERE titolo = ?";
    
    /** La query per la lettura di un singolo video. */
    private static final String READ_QUERY = "SELECT * FROM video WHERE titolo = ?";
    
    private static final String UPDATE_QUERY = "UPDATE video SET titolo=?, categoria=?, gratuito=?, id_insegnante=?, email_admin=? WHERE id_video = ?";

    private static final String GET_IDS = "Select id_video FROM video";

    @Override
    public List<Video> getAllVideo() {
        List<Video> listVideo = new ArrayList<Video>();
        Video v = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(READ_QUERY_ALL);
            statement.execute();
            result = statement.getResultSet();

            while(result.next()) {
                v = new Video(result.getInt(1), result.getString(2),
                        result.getString(3), result.getBoolean(4));
                

                /*
                Insegnante i = new Insegnante(result.getInt(7), result.getString(8),
                        result.getString(9), result.getString(10));


                v.setInsegnante(i);

                Admin a = new Admin(result.getString(11),result.getString(12));


                v.setAdmin(a);*/

                v.setUrlVideo("video/"+v.getIdVideo() + ".mp4");
                v.setUrlFoto("FotoVideo/"+ v.getIdVideo() + ".jpg");
                listVideo.add(v);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return listVideo;
    }
    
    @Override
    public Video getVideo(String titolo) {
    	
    	
        Video v = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(READ_QUERY);
            statement.setString(1, titolo);
            statement.execute();
            result = statement.getResultSet();

            if (result.next() && result != null) {
                v = new Video(result.getInt(1), result.getString(2),
                        result.getString(3), result.getBoolean(4));
                v.setIdinsegnante(result.getInt(5));
                System.out.println(v.getIdinsegnante());

            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }


        return v;
		

    }


    
    @Override
    public List<Video> getVideoByCategoria(String categoria) {




        List<Video> listVideo = new ArrayList<Video>();
        Video v = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(READ_QUERY_CATEGORIA);
            statement.setString(1, categoria);
            statement.execute();
            result = statement.getResultSet();

            while(result.next()) {

                v = new Video(result.getInt(1), result.getString(2),
                        result.getString(3), result.getBoolean(4));



                /*
                Insegnante i = new Insegnante(result.getInt(7), result.getString(8),
                        result.getString(9), result.getString(10));
                v.setInsegnante(i);
                
                System.out.println(i.getNome());


                Admin a = new Admin(result.getString(11),result.getString(12));
                v.setAdmin(a);

                
                System.out.println(a.getEmail()); */

                v.setUrlVideo("video/"+v.getIdVideo() + ".mp4");
                v.setUrlFoto("FotoVideo/"+ v.getIdVideo() + ".jpg");

                listVideo.add(v);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return listVideo;
    }


    
    @Override
    public List<Video> getVideoByInsegnante(String nome, String cognome) {
    	return null;
    	/*
        List<Video> listVideo = new ArrayList<Video>();
        Video v = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(READ_QUERY_INSEGNANTE);
            statement.setString(1, nome);
            statement.setString(2, cognome);
            statement.execute();
            result = statement.getResultSet();

            while(result.next()) {
                 v = new Video(result.getInt(1), result.getString(2),
                        result.getString(3), result.getBoolean(4));


                 /*
                 
                Insegnante i = new Insegnante(result.getInt(7), result.getString(8),
                        result.getString(9), result.getString(10));
                v.setInsegnante(i);

                Admin a = new Admin(result.getString(11),result.getString(12));
                v.setAdmin(a);
                
                */

    		/*
                v.setUrlVideo("video/"+v.getIdVideo() + ".mp4");
                v.setUrlFoto("FotoVideo/"+ v.getIdVideo() + ".jpg");

                listVideo.add(v);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return listVideo;
        */
    }

    @Override
    public int createVideo(String titolo, String categoria, boolean gratuito,
                               int id_insegnante, String email_admin) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, titolo);

            statement.setString(2, categoria);
            statement.setBoolean(3, gratuito);
            statement.setInt(4, id_insegnante);
            statement.setString(5, email_admin);


            int key=0;
            statement.executeUpdate();

            result = statement.getGeneratedKeys();
            if (result != null && result.next()) {
                key = result.getInt(1);
            }
                return key;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }

            return -1;
    }


    @Override
    public boolean deleteVideo(String titolo) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(DELETE_QUERY);
            statement.setString(1,titolo);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
    }

	@Override
	public boolean updateVideo(int id_video, String titolo, String categoria, boolean gratuito, int id_insegnante,
			String email_admin) {
		Connection con = null;
        PreparedStatement statement = null;
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(UPDATE_QUERY);
            statement.setString(1,titolo);
            statement.setString(2,categoria);
            statement.setBoolean(3,gratuito);
            statement.setInt(4,id_insegnante);
            statement.setString(5, email_admin);
            statement.setInt(6,id_video);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
	}

	@Override
	public List<Video> getVideoByKeyword(String keyword) {
		
		List<Video> listVideo = new ArrayList<Video>();
        Video v = null;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        
        System.out.println(keyword);

        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(READ_QUERY_KEYWORD);
            statement.setString(1, keyword);
            statement.execute();
            result = statement.getResultSet();

            while(result.next()) {
                 v = new Video(result.getInt(1), result.getString(2),
                        result.getString(3), result.getBoolean(4));


                 /*
                 
                Insegnante i = new Insegnante(result.getInt(7), result.getString(8),
                        result.getString(9), result.getString(10));
                v.setInsegnante(i);

                Admin a = new Admin(result.getString(11),result.getString(12));
                v.setAdmin(a);
                
                */


                v.setUrlVideo("video/"+v.getIdVideo() + ".mp4");
                v.setUrlFoto("FotoVideo/"+ v.getIdVideo() + ".jpg");

                listVideo.add(v);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return listVideo;
		
	}

	public boolean idIdValid(int id) {
		List<Integer> ids = new ArrayList<Integer>();
    	Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        
        try {
            con = MySQLDAO.createConnection();
            statement = con.prepareStatement(GET_IDS);
            statement.execute();
            result = statement.getResultSet();

            while (result.next() && result != null) {
             int idv = result.getInt(1);
             ids.add(idv);
            }
            
            for(int i=0; i < ids.size(); i++) {
            	if(id ==ids.get(i)) {
            		return true;
            	}
            }
            return false;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                con.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
		return false;

    	
    }
	

}
