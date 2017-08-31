package com.reviewportal.model.core;

public abstract interface IBaseEntity {

	public abstract void onPrePersist();

	public abstract void onPostPersist();

	public abstract void onPostLoad();

	public abstract void onPreUpdate();

	public abstract void onPostUpdate();

	public abstract void onPreRemove();

	public abstract void onPostRemove();

}
