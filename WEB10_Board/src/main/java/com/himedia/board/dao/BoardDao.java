package com.himedia.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.himedia.board.dto.BoardDto;
import com.himedia.board.dto.ReplyDto;
import com.himedia.board.util.Dbm;

public class BoardDao {
	
	private BoardDao() {}
	private static BoardDao itc = new BoardDao();
	public static BoardDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	
	public ArrayList<BoardDto> getAllBoard(){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		con = Dbm.getConnection();
		String sql = "select * from board order by num desc";
			try {
				pstmt = con.prepareStatement(sql);
				rs =pstmt.executeQuery();
				while(rs.next()) {
					BoardDto bdto = new BoardDto();
					bdto.setNum(rs.getInt("num"));
					bdto.setPass(rs.getString("pass"));
					bdto.setEmail(rs.getString("email"));
					bdto.setUserid(rs.getString("userid"));
					bdto.setTitle(rs.getString("title"));
					bdto.setContent(rs.getString("content"));
					bdto.setReadcount(rs.getInt("readcount"));
					bdto.setWritedate(rs.getTimestamp("writedate"));
					list.add(bdto);
					}
					}catch(SQLException e) {
						e.printStackTrace();
					} finally {
						Dbm.close(con, pstmt, rs); 
					}
					return list;
			}

	public void insertBoard(BoardDto bdto) {
		
		con = Dbm.getConnection();
		String sql="insert into board(userid, pass, email,title, content) values(?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getUserid());
			pstmt.setString(2, bdto.getPass());
			pstmt.setString(3, bdto.getEmail());
			pstmt.setString(4, bdto.getTitle());
			pstmt.setString(5, bdto.getContent());
			pstmt.executeUpdate();
			}catch(SQLException e) {
			e.printStackTrace();
			} finally {
				Dbm.close(con, pstmt, rs); 
			}
		}

	public void plusReadCount(int num) {
		con = Dbm.getConnection();
		String sql="update board set readcount = readcount+1 where num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs); 
		}
		
		
		
		
	}

	public BoardDto getBoard(int num) {
		BoardDto bdto = null;
		con = Dbm.getConnection();
		String sql="select*from board where num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs =pstmt.executeQuery();
			while(rs.next()) {
				bdto = new BoardDto();
				bdto.setNum(rs.getInt("num"));
				bdto.setPass(rs.getString("pass"));
				bdto.setEmail(rs.getString("email"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContent(rs.getString("content"));
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
				}
				}catch(SQLException e) {
					e.printStackTrace();
				} finally {
					Dbm.close(con, pstmt, rs); 
				}
				return bdto;
		}

	public void updateBoard(BoardDto bdto) {
		con = Dbm.getConnection();
		String sql="update board set pass=?, email=?, title=?, content=? where num=?";			
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getPass());
			pstmt.setString(2, bdto.getEmail());
			pstmt.setString(3, bdto.getTitle());
			pstmt.setString(4, bdto.getContent());
			pstmt.setInt(5, bdto.getNum());
			pstmt.executeUpdate();
			}catch(SQLException e) {
			e.printStackTrace();
			} finally {
				Dbm.close(con, pstmt, rs); 
			}
		}

	public void deleteBoard(int num) {
		con = Dbm.getConnection();
		String sql="delete from board where num=?";			
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs); 
		}
	}

	public ArrayList<ReplyDto> getReply(int num) {
		ArrayList<ReplyDto> list = new ArrayList<ReplyDto>();  
		con = Dbm.getConnection();
		String sql="select * from reply where boardnum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs =pstmt.executeQuery();
			while(rs.next()) {
				ReplyDto rdto = new ReplyDto();
				rdto.setReplynum(rs.getInt("replynum"));
				rdto.setBoardnum(rs.getInt("boardnum"));
				rdto.setUserid(rs.getString("userid"));
				rdto.setContent(rs.getString("content"));
				rdto.setWritedate(rs.getTimestamp("writedate"));
				list.add(rdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs); 
		}
		return list;
	}


		
}













