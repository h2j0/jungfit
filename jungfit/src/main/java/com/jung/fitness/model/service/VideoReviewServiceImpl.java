package com.jung.fitness.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.fitness.model.dao.VideoReviewDao;
import com.jung.fitness.model.dto.VideoReview;

@Service
public class VideoReviewServiceImpl implements VideoReviewService {

	@Autowired
	private VideoReviewDao vReviewDao;

	@Override
	public List<VideoReview> getVReviewList(HashMap<String, String> params) {
		return vReviewDao.selectList(params);
	}

	@Override
	public VideoReview readVReview(int id) {
		this.updateCnt(id);
		return vReviewDao.selectOne(id);
	}

	@Override
	public VideoReview getVReviewById(int id) {
		return vReviewDao.selectOne(id);
	}

	@Override
	public void writeVReview(VideoReview vReview) {
		vReviewDao.insertVReview(vReview);
	}

	@Override
	public void modifyVReview(VideoReview vReview) {
		VideoReview vr = vReviewDao.selectOne(vReview.getReviewId());
		vr.setTitle(vr.getTitle());
		vr.setContent(vr.getContent());
		vReviewDao.updateVReview(vr);
	}

	@Override
	public void removeVReview(int id) {
		vReviewDao.deleteVReview(id);
	}

	@Override
	public void updateCnt(int id) {
		VideoReview vr = vReviewDao.selectOne(id);
		vr.setViewCnt(vr.getViewCnt() + 1);
		vReviewDao.updateVReview(vr);
	}

}
