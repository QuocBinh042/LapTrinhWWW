package bai3.dao;

import java.util.List;

import bai3.models.TinTuc;

public interface TinTucDAO {
	public List<TinTuc> getAllTinTuc();

	public void addTinTuc(TinTuc tt);

	public void deleteTinTuc(int id);

	public List<Integer> getDanhMucId();
}
