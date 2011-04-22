/**
 * 
 */
package com.liferay.talelets.util;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.talelets.service.model.Talelet;

/**
 * Compares Talelets by their modified dates. 
 * @author Rich Sezov
 *
 */
public class TaleletModifiedDateComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "dateUpdated ASC";

	public static String ORDER_BY_DESC = "dateUpdated DESC";

	public static String[] ORDER_BY_FIELDS = {"dateUpdated"};
	
	public TaleletModifiedDateComparator() {
		this (false);
	}
	
	public TaleletModifiedDateComparator (boolean ascending) {
		_ascending = ascending;
	}
	
	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.util.OrderByComparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object obj1, Object obj2) {
		Talelet talelet1 = (Talelet)obj1;
		Talelet talelet2 = (Talelet)obj2;
		
		int value = DateUtil.compareTo(talelet1.getDateUpdated(), talelet2.getDateUpdated());
		
		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}
	
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	public boolean isAscending() {
		return _ascending;
	}
	
	private boolean _ascending;

}
