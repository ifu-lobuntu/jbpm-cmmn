package org.jbpm.cmmn.flow.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import de.malkusch.whoisServerList.publicSuffixList.PublicSuffixList;
import de.malkusch.whoisServerList.publicSuffixList.PublicSuffixListFactory;

public class NamespacePackageConverter {
    private static final Set<String> COUNTRIES = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(Locale.getISOCountries())));
    private static PublicSuffixList suffixList;
    static {
        PublicSuffixListFactory factory = new PublicSuffixListFactory();
        suffixList = factory.build();
    }

    public static void main(String[] args) throws Exception{
        System.out.println(toPackage(new URL("http://www.jbpm.org/designer/test/cmmn")));
        System.out.println(toNamespace("za.co.fiefie.kaploems.skwadams"));
        System.out.println(toNamespace("com.fiefie.kaploems.skwadams"));
        System.out.println(toNamespace("fiefie.kaploems.skwadams"));
        System.out.println(toNamespace("org.fiefie.kaploems.skwadams"));
        System.out.println(toPackage(toNamespace("za.co.fiefie.kaploems.skwadams")));
        System.out.println(toPackage(toNamespace("com.fiefie.kaploems.skwadams")));
        System.out.println(toPackage(toNamespace("fiefie.kaploems.skwadams")));
        System.out.println(toPackage(toNamespace("org.fiefie.kaploems.skwadams")));
    }

    public static URL toNamespace(String packageName) throws MalformedURLException {
        String uri=null;
        String[] split = packageName.split("\\.");
        if (split.length == 1) {
            uri="http://" + split[0];
        } else if (split.length == 2) {
            if (suffixList.isPublicSuffix(split[0])) {
                uri="http://" + split[1] + "." + split[0];
            } else {
                uri="http://" + split[0] + "/" + split[1];
            }
        } else {
            String twoPartDomain = split[1] + "." + split[0];
            String threePartDomain = split[2] + "." + twoPartDomain;
            StringBuilder sb = new StringBuilder("http://www.");
            int start = 0;
            if (suffixList.isRegistrable(threePartDomain)) {
                sb.append(threePartDomain);
                start = 3;
            } else if (suffixList.isRegistrable(twoPartDomain)) {
                sb.append(twoPartDomain);
                start = 2;
            }else{
                start=0;
            }
            for (int i = start; i < split.length; i++) {
                sb.append("/");
                sb.append(split[i]);
            }
            uri=sb.toString();
        }
        return new URL(uri);
    }
    public static String toPackage(URL url){
        String h = url.getHost();
        if(h.startsWith("www.")){
            h=h.substring(4);
        }
        String[] host = h.split("\\.");
        StringBuilder sb = new StringBuilder();
        for(int i = host.length-1;i>=0; i --){
            sb.append(host[i]);
            if(i>0){
                sb.append(".");
            }
        }
        if(url.getPath()==null || url.getPath().isEmpty()){
            return sb.toString();
        }else{
            sb.append(url.getPath().replaceAll("\\/", "."));
            return sb.toString();
        }
    }
}
