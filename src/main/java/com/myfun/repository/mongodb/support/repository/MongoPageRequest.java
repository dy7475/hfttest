package com.myfun.repository.mongodb.support.repository;

import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 为了和数据库分页保持一致 分页从0开始
 * 
 * @author Administrator
 *
 */
public class MongoPageRequest extends AbstractPageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Sort sort;

	public MongoPageRequest(int page, int size) {
		this(page, size, null);
	}

	public MongoPageRequest(int page, int size, Sort.Direction direction, String[] properties) {
		this(page, size, new Sort(direction, properties));
	}

	public MongoPageRequest(int page, int size, Sort sort) {
		super(page - 1, size);
		this.sort = sort;
	}

	public Sort getSort() {
		return this.sort;
	}

	public Pageable next() {
		return new MongoPageRequest(getPageNumber() + 1, getPageSize(), getSort());
	}

	public MongoPageRequest previous() {
		return getPageNumber() == 0 ? this : new MongoPageRequest(getPageNumber() - 1, getPageSize(), getSort());
	}

	public Pageable first() {
		return new MongoPageRequest(0, getPageSize(), getSort());
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MongoPageRequest)) {
			return false;
		}

		MongoPageRequest that = (MongoPageRequest) obj;

		boolean sortEqual = this.sort == null ? false : that.sort == null ? true : this.sort.equals(that.sort);

		return (super.equals(that)) && (sortEqual);
	}

	public int hashCode() {
		return 31 * super.hashCode() + (null == this.sort ? 0 : this.sort.hashCode());
	}

	public String toString() {
		return String.format("Page request [number: %d, size %d, sort: %s]",
				new Object[] { Integer.valueOf(getPageNumber()), Integer.valueOf(getPageSize()),
						this.sort == null ? null : this.sort.toString() });
	}

}
