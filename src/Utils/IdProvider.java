/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.UUID;

/**
 *
 * @author mrs.katey
 */
public class IdProvider {
    public static long getUUID() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}