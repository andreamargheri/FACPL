package it.unifi.xtext.facpl.ui.wizard;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class Facpl2ProjectCreatorCustom extends Facpl2ProjectCreator {

	protected static final String LOG4J = "log4j";

	@Override
	protected List<String> getRequiredBundles() {

		return Lists.newArrayList("FACPL_Library", "XacmlToFacpl");
	}

	@Override
	protected List<String> getAllFolders() {
		return ImmutableList.of(SRC_ROOT, LOG4J);
	}

}
