//
//  winners.swift
//  abelm_assignment8
//
//  Created by Abel Marin on 3/2/21.
//

import Foundation

let winners = [
    Winner(name: "Los Angeles Dodgers",
        type: .national,
        shortDescription: "2020: def. Tampa Bay Rays",
        longDescription: "The Los Angeles Dodgers beat the Tampa Bay Rays in a 6 game series 4-2."),
    
    Winner(name: "Washington Nationals",
        type: .national,
        shortDescription: "2019: def. Houston Astros",
        longDescription: "The Washington Nationals beat the Houston Astros in a 7 game series 4-3."),
    
    Winner(name: "Boston Red Sox",
        type: .american,
        shortDescription: "2018: def. Los Angeles Dodgers",
        longDescription: "The Boston Red Sox beat the Los Angeles Dodgers in a 5 game series 4-1."),
    
    Winner(name: "Houston Astros",
        type: .american,
        shortDescription: "2017: def. Los Angeles Dodgers",
        longDescription: "The Houston Astros beat the Los Angeles Dodgers in a 7 game series 4-3."),
    
    Winner(name: "Chicago Cubs",
        type: .national,
        shortDescription: "2016: def. Cleveland Indians",
        longDescription: "The Chicago Cubs beat the Cleveland Indians in a 7 game series 4-3."),
    
    Winner(name: "Kansas City Royals",
        type: .american,
        shortDescription: "2015: def. New York Mets",
        longDescription: "The Kansas City Royals beat the New York Mets in a 5 game series 4-1."),
    
    Winner(name: "San Francisco Giants",
        type: .national,
        shortDescription: "2014: def. Kansas City Royals",
        longDescription: "The San Francisco Giants beat the Kansas City Royals in a 7 game series 4-3."),
    
    Winner(name: "Boston Red Sox",
        type: .american,
        shortDescription: "2013: def. St. Louis Cardinals",
        longDescription: "The Boston Red Sox beat the St. Louis Cardinals in a 6 game series 4-2."),
    
    Winner(name: "San Francisco Giants",
            type: .national,
            shortDescription: "2012: def. Detroit Tigers",
            longDescription: "The San Francisco Giants beat the Detroit Tigers in a sweep 4-0."),
    
    Winner(name: "St. Louis Cardinals",
        type: .national,
        shortDescription: "2011: def. Texas Rangers",
        longDescription: "The St. Louis Cardinals beat the Texas Rangers in a 7 game series 4-3."),
    
    Winner(name: "San Francisco Giants",
            type: .national,
            shortDescription: "2010: def. Texas Rangers",
            longDescription: "The San Francisco Giants beat the Texas Rangers in a 5 game series 4-1."),
    
    Winner(name: "New York Yankees",
        type: .american,
        shortDescription: "2009: def. Philadelphia Phillies",
        longDescription: "The New York Yankees beat the Philadelphia Phillies in a 6 game series 4-2."),
    
    Winner(name: "Philadelphia Phillies",
        type: .national,
        shortDescription: "2008: def. Tampa Bay Rays",
        longDescription: "The Philadelphia Phillies beat the Tampa Bay Rays in a 5 game series 4-1."),
    
    Winner(name: "Boston Red Sox",
            type: .american,
            shortDescription: "2007: def. Colorado Rockies",
            longDescription: "The Boston Red Sox beat the Colorado Rockies in a sweep 4-0."),
    
    Winner(name: "St. Louis Cardinals",
            type: .national,
            shortDescription: "2006: def. Detroit Tigers",
            longDescription: "The St. Louis Cardinals beat the Detroit Tigers in a 5 game series 4-1."),
    
    Winner(name: "Chicago White Sox",
        type: .american,
        shortDescription: "2005: def. Houston Astros",
        longDescription: "The Chicago White Sox beat the Houston Astros in a sweep 4-0."),
    
    Winner(name: "Boston Red Sox",
            type: .american,
            shortDescription: "2004: def. St. Louis Cardinals",
            longDescription: "The Boston Red Sox beat the St. Louis Cardinals in a sweep 4-0.")
    
]


class Winner {
    enum `Type`: String {
        case national = "national"
        case american = "american"
    }
    
    var name: String
    var type: Type
    var shortDescription: String
    var longDescription: String
    
    init(name: String, type: Type, shortDescription: String, longDescription: String) {
        self.name = name
        self.type = type
        self.shortDescription = shortDescription
        self.longDescription = longDescription
    }
}
