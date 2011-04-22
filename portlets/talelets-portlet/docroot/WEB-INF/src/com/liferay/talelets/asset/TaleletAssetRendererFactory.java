package com.liferay.talelets.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.liferay.talelets.service.model.Talelet;
import com.liferay.talelets.service.service.TaleletLocalServiceUtil;

public class TaleletAssetRendererFactory extends BaseAssetRendererFactory {
	
	public static final String CLASS_NAME = Talelet.class.getName();
	public static final String TYPE = "talelet";
	
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type)
			throws PortalException, SystemException {
		
		Talelet talelet = TaleletLocalServiceUtil.getTalelet(classPK);
		
		return new TaleletAssetRenderer (talelet);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
