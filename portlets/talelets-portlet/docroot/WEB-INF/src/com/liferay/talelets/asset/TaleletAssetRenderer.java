package com.liferay.talelets.asset;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.liferay.talelets.service.model.Talelet;
import com.liferay.talelets.util.WebKeys;

public class TaleletAssetRenderer extends BaseAssetRenderer {
	
	public TaleletAssetRenderer(Talelet talelet) {
		_talelet = talelet;
	}

	@Override
	public long getClassPK() {
		return _talelet.getTaleId();
	}

	@Override
	public long getGroupId() {
		return _talelet.getGroupId();
	}

	@Override
	public String getSummary() {
		String summary = StringUtil.shorten(_talelet.getContent(), 200);
		return summary;
	}

	@Override
	public String getTitle() {
		return _talelet.getTaleTitle();
	}

	@Override
	public long getUserId() {
		return _talelet.getUserId();
	}

	@Override
	public String getUuid() {
		return _talelet.getUuid();
	}

	@Override
	public String render(RenderRequest request, RenderResponse response, String template)
			throws Exception {
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
            request.setAttribute(WebKeys.TALELET_ENTRY, _talelet);

            return "/html/" + template + ".jsp";
        }
        else {
            return null;
        }
    }
	
	
	private Talelet _talelet;

}
