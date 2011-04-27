package com.liferay.talelets.social;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.social.model.BaseSocialActivityInterpreter;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityFeedEntry;
import com.liferay.talelets.service.model.Talelet;
import com.liferay.talelets.service.service.TaleletLocalServiceUtil;

public class TaleletSocialActivityInterpreter extends
		BaseSocialActivityInterpreter {

	@Override
	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	protected SocialActivityFeedEntry doInterpret(SocialActivity activity,
			ThemeDisplay themeDisplay) throws Exception {
		
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		
		Talelet talelet = TaleletLocalServiceUtil.getTalelet(activity.getClassPK());
		
		if (!permissionChecker.hasPermission(talelet.getGroupId(), Talelet.class.getName(), talelet.getTaleId(), ActionKeys.VIEW)) {
			return null;
		}
		
		String link = StringPool.BLANK;
		String key = "activity-talelet-add-talelet";
		String title = getTitle(activity, key, talelet.getTaleTitle(), link, themeDisplay);
		String body = StringUtil.shorten(talelet.getContent(), 200);
		
		return new SocialActivityFeedEntry(link, title, body);
	}
	
	protected String getTitle(SocialActivity activity, String key, String content, String link, ThemeDisplay themeDisplay) {
		String userName = getUserName(activity.getUserId(), themeDisplay);
		String text = HtmlUtil.escape(cleanContent(content));
		
		if (Validator.isNotNull(link)) {
			text = wrapLink(link, text);
		}
		
		String groupName = StringPool.BLANK;
		
		if (activity.getGroupId() != themeDisplay.getScopeGroupId()) {
			groupName = getGroupName(activity.getGroupId(), themeDisplay);
		}
		
		String pattern = key;
		
		if (Validator.isNotNull(groupName)) {
			pattern +="-in";
		}
		
		return themeDisplay.translate(pattern, new Object[] {userName, text, groupName});
		
	}
	
	private static final String[] _CLASS_NAMES = new String [] {
		Talelet.class.getName()
	};

}
