import React from "react";

function ContainsVowel(props) {
    return <p>The given string "{props.str}" contains at least one vowel.</p>;
}

function NoVowel(props) {
    return <p>The given string "{props.str}" does not contain any vowels.</p>;
}

function CheckVowel(props) {
    const vowels = /[aeiouAEIOU]/; 
    if (vowels.test(props.str)) {
        return <ContainsVowel str={props.str} />;
    }
    return <NoVowel str={props.str} />;
}

export default CheckVowel;
