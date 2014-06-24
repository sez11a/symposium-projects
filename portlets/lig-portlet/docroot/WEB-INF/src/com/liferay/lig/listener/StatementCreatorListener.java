
package com.liferay.lig.listener;

import java.io.InputStreamReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.liferay.lig.model.Insult;
import com.liferay.lig.model.impl.InsultImpl;
import com.liferay.lig.service.InsultLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletLayoutListener;
import com.liferay.portal.kernel.portlet.PortletLayoutListenerException;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;


/**
 * This class is a listener which adds the default statements
 * to the database the first time the portlet is added to a page.
 * If the portlet is removed and re-added, the statements won't
 * be re-added.
 *
 * @author Rich Sezov
 *
 */
public class StatementCreatorListener implements PortletLayoutListener {

    @SuppressWarnings("unchecked")
    @Override
    public void onAddToLayout(String portletId, long plid)
        throws PortletLayoutListenerException {

        try {

            Layout layout = LayoutLocalServiceUtil.getLayout(plid);
            long companyId = layout.getCompanyId();
            long groupId = layout.getGroupId();

            ColumnPositionMappingStrategy strat =
                new ColumnPositionMappingStrategy();
            strat.setType(InsultImpl.class);
            String[] columns =
                new String[] {
                    "adjectiveOne", "directObject", "adjectiveTwo",
                    "objPreposition"
                };
            strat.setColumnMapping(columns);

            CsvToBean csv = new CsvToBean();

            ClassLoader classLoader = this.getClass().getClassLoader();

            CSVReader reader =
                new CSVReader(new InputStreamReader(
                    classLoader.getResourceAsStream("insults.csv")));

            List list = csv.parse(strat, reader);

            Insult testInsult = (Insult) list.get(0);

            if (InsultLocalServiceUtil.getInsultByObjPreposition(testInsult.getObjPreposition()) == null) {

                for (int i = 0; i < list.size(); i++) {

                    Insult insult = (Insult) list.get(i);
                    insult.setCompanyId(companyId);
                    insult.setGroupId(groupId);
                    InsultLocalServiceUtil.addInsult(insult, 0);

                }

            }

        }
        catch (PortalException e) {
            System.out.println("PortalException: " + e.getMessage());
        }
        catch (SystemException e) {
         System.out.println("SystemException: " + e.getMessage());
        }

    }

    @Override
    public void onMoveInLayout(String arg0, long arg1)
        throws PortletLayoutListenerException {

        // not implemented

    }

    @Override
    public void onRemoveFromLayout(String arg0, long arg1)
        throws PortletLayoutListenerException {

        // not implemented

    }

}
