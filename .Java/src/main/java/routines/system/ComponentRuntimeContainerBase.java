// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package routines.system;

import java.util.Date;
import java.util.Map;

import org.talend.components.api.runtime.ComponentDynamicHolder;
import org.talend.components.api.runtime.ComponentRuntimeContainer;

public class ComponentRuntimeContainerBase implements ComponentRuntimeContainer {

	@Override
	public ComponentDynamicHolder createDynamicHolder() {
		throw new RuntimeException("This must be subclassed");
	}

	@Override
	public String formatDate(Date date, String pattern) {
		return FormatterUtils.format(date, pattern);
	}

	@Override
	public Map<String, Object> getGlobalMap() {
		throw new RuntimeException("This must be subclassed");
	}

}
