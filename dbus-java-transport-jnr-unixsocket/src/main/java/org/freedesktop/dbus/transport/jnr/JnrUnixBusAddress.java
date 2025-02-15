package org.freedesktop.dbus.transport.jnr;

import org.freedesktop.dbus.connections.BusAddress;
import org.freedesktop.dbus.connections.transports.IFileBasedBusAddress;
import org.freedesktop.dbus.utils.Util;

import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class JnrUnixBusAddress extends BusAddress implements IFileBasedBusAddress {

    public JnrUnixBusAddress(BusAddress _obj) {
        super(_obj);
    }

    public boolean hasPath() {
        return getParameters().containsKey("path");
    }

    public String getAbstract() {
        return getParameters().get("abstract");
    }

    public boolean isAbstract() {
        return getParameters().containsKey("abstract");
    }

    public String getPath() {
        return getParameters().get("path");
    }

    @Override
    public void updatePermissions(String _fileOwner, String _fileGroup, Set<PosixFilePermission> _fileUnixPermissions) {
        Util.setFilePermissions(Path.of(getPath()), _fileOwner, _fileGroup, _fileUnixPermissions);
    }

}
