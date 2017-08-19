package com.reviewportal.service.impl.converter;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.hibernate.collection.internal.PersistentSet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.reviewportal.model.entities.AbstractEntity;
import com.reviewportal.service.dto.AbstractDTO;
import com.reviewportal.service.dto.UserRoleDTO;
import com.reviewportal.service.exceptions.SystemServiceException;

/**
 * @author imfroz
 *
 * @param <E>
 * @param <D>
 */
public abstract class AbstractEntityTOConverter<E extends AbstractEntity, D extends AbstractDTO> {

	Class<?> entityClass;
	Class<?> dtoClass;

	@Autowired
	protected EntityTOConverterFactory converterFactory;

	@Deprecated
	public D getDtoDeprecated(E pEntity) {

		D lTarget = getNewDtoInstance();
		BeanUtils.copyProperties(pEntity, lTarget);
		return lTarget;
	}

	@SuppressWarnings("unchecked")
	public Collection<D> getDtos(Iterable<E> pEntities, Class<?> pTargetType) throws Exception {
		Object lNewInstance = pTargetType.newInstance();
		Collection<D> lTargets = (Collection<D>) lNewInstance;

		for (E lEntity : pEntities) {
			D lTo = getDto(lEntity);
			try {
				lTargets.add(lTo);
			} catch (Exception lE) {
				System.out.println();
			}
		}

		return lTargets;
	}

	public List<D> getDtos(List<E> pEntity) throws SystemServiceException {

		// if(pEntity==null){
		// throw new SystemServiceException("Argument cannot be NULL");
		// }

		List<D> lTargets = new ArrayList<>();

		for (E lEntity : pEntity) {
			D lTo = getDto(lEntity);
			lTargets.add(lTo);
		}

		return lTargets;
	}

	@SuppressWarnings("unchecked")
	public D getDto(E pEntity) throws SystemServiceException {
		D lTarget = getNewDtoInstance();
		BeanUtils.copyProperties(pEntity, lTarget, getComplexTypes());
		for (String lFieldName : getComplexTypes()) {

			Field lField;
			try {

				try {
					lField = pEntity.getClass().getDeclaredField(lFieldName);
				} catch (NoSuchFieldException e) {
					lField = pEntity.getClass().getSuperclass().getDeclaredField(lFieldName);
				}
				lField.setAccessible(true);
				Object lObject = lField.get(pEntity);
				lField.setAccessible(false);
				if (lObject == null) {
					continue;
				}
				Class<? extends Object> lCollectionType = lObject.getClass();
				if (lObject instanceof Iterable) {
					ParameterizedType lParameterizedType = (ParameterizedType) lField.getGenericType();
					Class<?> lClass = (Class<?>) lParameterizedType.getActualTypeArguments()[0];
					AbstractEntityTOConverter<AbstractEntity, AbstractDTO> lMapper = this.getMapper(lClass);
					Iterable<AbstractEntity> lObject2 = (Iterable<AbstractEntity>) lObject;
					Collection<AbstractDTO> lDtos = null;
					if (lObject instanceof PersistentSet) {
						lDtos = lMapper.getDtos(lObject2, HashSet.class);
					} else {
						lDtos = lMapper.getDtos(lObject2, lCollectionType);
					}
					Field lEntityField = null;
					try {
						lEntityField = lTarget.getClass().getDeclaredField(lFieldName);
					} catch (NoSuchFieldException e) {
						lEntityField = lTarget.getClass().getSuperclass().getDeclaredField(lFieldName);
					}
					lEntityField.setAccessible(true);
					lEntityField.set(lTarget, lDtos);
					lEntityField.setAccessible(false);
				} else {
					AbstractEntityTOConverter<AbstractEntity, AbstractDTO> lMapper = getMapper(lCollectionType);
					AbstractDTO lDto = lMapper.getDto((AbstractEntity) lObject);
					Field lEntityField = null;
					try {
						lEntityField = lTarget.getClass().getDeclaredField(lFieldName);
					} catch (NoSuchFieldException e) {
						lEntityField = lTarget.getClass().getSuperclass().getDeclaredField(lFieldName);
					}
					lEntityField.setAccessible(true);

					lEntityField.set(lTarget, lDto);
					lEntityField.setAccessible(false);
				}

				System.out.println();
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
					| InstantiationException pException0) {
				throw new SystemServiceException("Error occure while converting Entity to DTO: " + getClass().getName(),
						pException0);
			} catch (Exception pException1) {
				throw new SystemServiceException("Error occure while converting Entity to DTO: " + getClass().getName(),
						pException1);
			}

		}
		return lTarget;
	}

	@Deprecated
	public E getEnityDeprecated(D pDto) {
		E lTarget = getNewEntityInstance();
		BeanUtils.copyProperties(pDto, lTarget);
		return lTarget;
	}

	@SuppressWarnings("unchecked")
	public E getEnity(D pDto) throws SystemServiceException {
		E lTarget = getNewEntityInstance();
		BeanUtils.copyProperties(pDto, lTarget, getComplexTypes());
		for (String lFieldName : getComplexTypes()) {

			Field lField;
			try {

				try {
					lField = pDto.getClass().getDeclaredField(lFieldName);
				} catch (NoSuchFieldException e) {
					lField = pDto.getClass().getSuperclass().getDeclaredField(lFieldName);
				}
				lField.setAccessible(true);
				Object lObject = lField.get(pDto);
				if (lObject == null) {
					continue;
				}
				lField.setAccessible(false);
				Class<? extends Object> lCollectionType = lObject.getClass();
				if (lObject instanceof Iterable) {
					ParameterizedType lParameterizedType = (ParameterizedType) lField.getGenericType();
					Class<?> lClass = (Class<?>) lParameterizedType.getActualTypeArguments()[0];
					AbstractEntityTOConverter<AbstractEntity, AbstractDTO> lMapper = getMapper(lClass);
					Iterable<AbstractDTO> lObject2 = (Iterable<AbstractDTO>) lObject;
					Collection<AbstractEntity> lEnities = lMapper.getEnities(lObject2, lCollectionType);
					Field lEntityField = null;
					try {
						lEntityField = lTarget.getClass().getDeclaredField(lFieldName);
					} catch (NoSuchFieldException e) {
						lEntityField = lTarget.getClass().getSuperclass().getDeclaredField(lFieldName);
					}
					lEntityField.setAccessible(true);
					lEntityField.set(lTarget, lEnities);
					lEntityField.setAccessible(false);
				} else {
					AbstractEntityTOConverter<AbstractEntity, AbstractDTO> lMapper = getMapper(lCollectionType);
					AbstractEntity lEnity = lMapper.getEnity((AbstractDTO) lObject);
					Field lEntityField = null;
					try {
						lEntityField = lTarget.getClass().getDeclaredField(lFieldName);
					} catch (NoSuchFieldException e) {
						lEntityField = lTarget.getClass().getSuperclass().getDeclaredField(lFieldName);
					}
					lEntityField.setAccessible(true);

					lEntityField.set(lTarget, lEnity);
					lEntityField.setAccessible(false);
				}

				System.out.println();
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
					| InstantiationException pException0) {
				throw new SystemServiceException("Error occure while converting Entity to DTO: " + getClass().getName(),
						pException0);
			} catch (Exception pException1) {
				throw new SystemServiceException("Error occure while converting Entity to DTO: " + getClass().getName(),
						pException1);
			}

		}
		return lTarget;
	}

	public List<E> getEnities(Iterable<D> pDtos) throws SystemServiceException {
		List<E> lTargets = new ArrayList<>();

		for (D lDto : pDtos) {
			E lTo = getEnity(lDto);
			lTargets.add(lTo);
		}

		return lTargets;
	}

	@SuppressWarnings("unchecked")
	public Collection<E> getEnities(Iterable<D> pDtos, Class<?> pTargetType) throws Exception {
		Object lNewInstance = pTargetType.newInstance();
		Collection<E> lTargets = (Collection<E>) lNewInstance;

		for (D lDto : pDtos) {
			E lTo = getEnity(lDto);
			lTargets.add(lTo);
		}

		return lTargets;
	}

	abstract D getNewDtoInstance();

	abstract E getNewEntityInstance();

	public String[] getComplexTypes() {
		return new String[] {};
	}

	protected <T extends AbstractEntityTOConverter<AbstractEntity, AbstractDTO>> T getMapper(Class<?> pClass)
			throws Exception {

		UserRoleDTO.class.getName();

		switch (pClass.getName()) {

		case "com.reviewportal.service.dto.UserDTO":
			return converterFactory.getMapper(UserConverter.class);

		case "com.reviewportal.model.entities.User":
			return converterFactory.getMapper(UserConverter.class);

		case "com.reviewportal.service.dto.UserRoleDTO":
			return converterFactory.getMapper(UserRoleConverter.class);

		case "com.reviewportal.model.entities.UserRole":
			return converterFactory.getMapper(UserRoleConverter.class);

		case "com.reviewportal.service.dto.ProfessionReviewDTO":
			return converterFactory.getMapper(ProfessionReviewConverter.class);

		case "com.reviewportal.model.entities.ProfessionReview":
			return converterFactory.getMapper(UserRoleConverter.class);

		case "com.reviewportal.service.dto.ReviewWriterDTO":
			return converterFactory.getMapper(ReviewWriterConverter.class);

		case "com.reviewportal.model.entities.ReviewWriter":
			return converterFactory.getMapper(ReviewWriterConverter.class);

		case "com.reviewportal.service.dto.AddressDTO":
			return converterFactory.getMapper(AddressConverter.class);

		case "com.reviewportal.model.entities.Address":
			return converterFactory.getMapper(AddressConverter.class);

		case "com.reviewportal.service.dto.ProfessionalDTO":
			return converterFactory.getMapper(ProfessionalConverter.class);

		case "com.reviewportal.model.entities.Professional":
			return converterFactory.getMapper(ProfessionalConverter.class);

		case "com.reviewportal.service.dto.ProfessionDTO":
			return converterFactory.getMapper(ProfessionConverter.class);

		case "com.reviewportal.model.entities.Profession":
			return converterFactory.getMapper(ProfessionConverter.class);

		default:
			throw new Exception("No AbstractEntityTOConverter found for class: " + pClass.getName());
		}

	}

	public EntityTOConverterFactory getConverterFactory() {
		return converterFactory;
	}

}
